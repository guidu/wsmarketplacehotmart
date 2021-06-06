package com.br.wsmarketplacehotmart.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.wsmarketplacehotmart.dto.ProductDTO;
import com.br.wsmarketplacehotmart.dto.ProductInformationDTO;
import com.br.wsmarketplacehotmart.model.AssessProduct;
import com.br.wsmarketplacehotmart.model.Product;
import com.br.wsmarketplacehotmart.service.AssessProductServiceImpl;
import com.br.wsmarketplacehotmart.service.ProductServiceImpl;
import com.br.wsmarketplacehotmart.service.SaleService;
import com.br.wsmarketplacehotmart.util.OrderList;
import com.br.wsmarketplacehotmart.util.Score;
import com.br.wsmarketplacehotmart.view.ProductAlterForm;
import com.br.wsmarketplacehotmart.view.ProductForm;

@RestController
@RequestMapping("/api/wsmarkeplaehotmart")
public class ProductController {

	@Autowired
	public ProductServiceImpl productServiceImpl;
	@Autowired
	public AssessProductServiceImpl assessProductServiceImpl;
	@Autowired
	public SaleService saleService;

	@GetMapping("/list")
	@Cacheable("listProduct")
	public Page<ProductDTO> list(Pageable pageable) {
		Page<Product> productList = productServiceImpl.listAllProduct(pageable);
		return ProductDTO.convert(productList);
	}

	@GetMapping("/find/{identifier}")
	public Page<ProductDTO> find(@PathVariable Integer identifier, @RequestParam Pageable pageable,
			UriComponentsBuilder uriComponentsBuilder) {
		Page<Product> product = productServiceImpl.findProduct(identifier, pageable);
		return ProductDTO.convert(product);
	}

	@DeleteMapping("/delete/{identifier}")
	@CacheEvict(value = "listProduct", allEntries = true)
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Integer identifier) {
		Optional<Product> product = productServiceImpl.findProduct(identifier);
		if (product.isPresent()) {
			productServiceImpl.delete(identifier);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/update/{identifier}")
	@CacheEvict(value = "listProduct", allEntries = true)
	@Transactional
	public ResponseEntity<ProductDTO> update(@PathVariable Integer identifier,
			@RequestBody ProductAlterForm productAlterForm) {
		Optional<Product> product = productServiceImpl.findProduct(identifier);
		if (product.isPresent()) {
			Product p = productAlterForm.convertProduct();
			productServiceImpl.update(p, identifier);
			return ResponseEntity.ok(new ProductDTO(p));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping("/insert")
	@CacheEvict(value = "listProduct", allEntries = true)
	@Transactional
	public ResponseEntity<ProductDTO> create(@RequestBody ProductForm productForm,
			UriComponentsBuilder uriComponentsBuilder) {
		Product product = productForm.convertProduct();
		productServiceImpl.insert(product);
		URI uri = uriComponentsBuilder.path("/productlist/{id}").buildAndExpand(product.getIdentifier()).toUri();
		return ResponseEntity.created(uri).body(new ProductDTO(product));
	}

	@GetMapping("/findorderedproducts")
	public ProductInformationDTO listProductOrder() {
		List<Product> productList = productServiceImpl.listAllProduct();
		productList.forEach(s -> {
			s.setScore(new Score().calcule(averageProductEvaluationInTheLast12Months(s.getIdentifier()),
					productSalesQuantity(s.getIdentifier()),
					productServiceImpl.amountOfProductCategoryNews(s.getCategoryProduct().getName())));
		});
		OrderList.orderListProduct(productList);
		// TODO alterar termo fixo, para termo que o cliente enviar
		
		return new ProductInformationDTO("termo", productList);
	}

	/*
	 * X = Média de avaliação do produto nos últimos 12 meses
	 */
	private Double averageProductEvaluationInTheLast12Months(Integer identifierProduct) {
		LocalDateTime currentDate = LocalDateTime.now();
		LocalDateTime dateAYearAgo = currentDate.minusYears(1);
		List<AssessProduct> list = assessProductServiceImpl.findAssessProductByIdentefierPeriod(identifierProduct,
				currentDate, dateAYearAgo);
		int countNote0 = 0;
		int countNote1 = 0;
		int countNote2 = 0;
		int countNote3 = 0;
		int countNote4 = 0;
		int countNote5 = 0;
		Double average = 0.0;
		if (!list.isEmpty()) {
			for (AssessProduct a : list) {
				if (a.getAssessProductEnum().getIdentifier() == 0) {
					countNote0++;
				}
				if (a.getAssessProductEnum().getIdentifier() == 1) {
					countNote1++;
				}
				if (a.getAssessProductEnum().getIdentifier() == 2) {
					countNote2++;
				}
				if (a.getAssessProductEnum().getIdentifier() == 3) {
					countNote3++;
				}
				if (a.getAssessProductEnum().getIdentifier() == 4) {
					countNote4++;
				}
				if (a.getAssessProductEnum().getIdentifier() == 5) {
					countNote5++;
				}
			}
			int summation = (countNote0 + countNote1 + countNote2 + countNote3 + countNote4 + countNote5);
			average = ((countNote0 * 0) + (countNote1 * 1) + (countNote2 * 2) + (countNote3 * 3) + (countNote4 * 4)
					+ (countNote5 * 5)) / summation * 1.0;
		}
		return average;
	}

	/*
	 * Y = Quantidade de vendas/dias que o produto existe
	 */
	private long productSalesQuantity(Integer identifierProduct) {
		long quantityOfSales = saleService.findProductSalesQuantity(identifierProduct);
		Optional<Product> product = productServiceImpl.findProduct(identifierProduct);
		long daysTheProductExists = ChronoUnit.DAYS.between(product.get().getDateCreation(), LocalDateTime.now());
		if (daysTheProductExists == 0) {
			return 0;
		} else {
			return quantityOfSales / daysTheProductExists;
		}
	}

}
