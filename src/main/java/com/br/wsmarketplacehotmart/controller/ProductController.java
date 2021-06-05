package com.br.wsmarketplacehotmart.controller;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.wsmarketplacehotmart.dto.ArticlesDTO;
import com.br.wsmarketplacehotmart.dto.NewsAPIDTO;
import com.br.wsmarketplacehotmart.dto.ProductDTO;
import com.br.wsmarketplacehotmart.dto.ProductInformationDTO;
import com.br.wsmarketplacehotmart.model.AssessProduct;
import com.br.wsmarketplacehotmart.model.Product;
import com.br.wsmarketplacehotmart.service.AssessProductService;
import com.br.wsmarketplacehotmart.service.ProductService;
import com.br.wsmarketplacehotmart.service.SaleService;
import com.br.wsmarketplacehotmart.util.OrderList;
import com.br.wsmarketplacehotmart.util.Score;
import com.br.wsmarketplacehotmart.view.ProductAlterForm;
import com.br.wsmarketplacehotmart.view.ProductForm;

@RestController
@RequestMapping("/api/wsmarkeplaehotmart")
public class ProductController {

	@Autowired
	public ProductService productService;
	@Autowired
	public AssessProductService assessProductService;
	@Autowired
	public SaleService saleService;

	@GetMapping("/list")
	public List<ProductDTO> list() {
		List<Product> productList = productService.listAllProduct();
		return new ProductDTO().getProductList(productList);
	}

	@GetMapping("/find/{identifier}")
	public ProductDTO find(@PathVariable Integer identifier, UriComponentsBuilder uriComponentsBuilder) {
		Optional<Product> product = productService.findProduct(identifier);
		return new ProductDTO(product.get());
	}

	@DeleteMapping("/delete/{identifier}")
	@Transactional
	public List<ProductDTO> delete(@PathVariable Integer identifier) {
		productService.delete(identifier);
		List<Product> productList = productService.listAllProduct();
		return new ProductDTO().getProductList(productList);
	}

	@PutMapping("/update/{identifier}")
	@Transactional
	public ResponseEntity<ProductDTO> update(@PathVariable Integer identifier,
			@RequestBody ProductAlterForm productAlterForm) {
		Product product = productAlterForm.convertProduct();
		productService.update(product, identifier);
		return ResponseEntity.ok(new ProductDTO(product));
	}

	@PostMapping("/insert")
	@Transactional
	public ResponseEntity<ProductDTO> create(@RequestBody ProductForm productForm,
			UriComponentsBuilder uriComponentsBuilder) {
		Product product = productForm.convertProduct();
		productService.insert(product);
		URI uri = uriComponentsBuilder.path("/productlist/{id}").buildAndExpand(product.getIdentifier()).toUri();
		return ResponseEntity.created(uri).body(new ProductDTO(product));
	}

	@GetMapping("/findorderedproducts")
	public ProductInformationDTO listProductOrder() {
		List<Product> productList = productService.listAllProduct();
		productList.forEach(s -> {
			s.setScore(new Score().calcule(averageProductEvaluationInTheLast12Months(s.getIdentifier()), productSalesQuantity(s.getIdentifier()),
					amountOfProductCategoryNews(s.getCategoryProduct().getName())));
		});
		new OrderList().orderListProduct(productList);
		return new ProductInformationDTO("termo",productList);
	}

	/*
	 * X = Média de avaliação do produto nos últimos 12 meses
	 */
	public Double averageProductEvaluationInTheLast12Months(Integer identifierProduct) {
		LocalDateTime currentDate = LocalDateTime.now();
		LocalDateTime dateAYearAgo = currentDate.minusYears(1);
		List<AssessProduct> list = assessProductService.findAssessProductByIdentefierPeriod(identifierProduct,
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
	public long productSalesQuantity(Integer identifierProduct) {
		long quantityOfSales = saleService.findProductSalesQuantity(identifierProduct);
		Optional<Product> product = productService.findProduct(identifierProduct);
		long daysTheProductExists = ChronoUnit.DAYS.between(product.get().getDateCreation(),
				LocalDateTime.now());
		if (daysTheProductExists == 0) { 
			return 0;
		} else {
			return quantityOfSales / daysTheProductExists;
		}
	}
//	Z = Quantidade de notícias da categoria do produto no dia corrente

	public long amountOfProductCategoryNews(String categoria) {
		return totalDailyNews(categoria);
	}

	public Integer totalDailyNews(String category) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://newsapi.org/v2/top-headlines?category=" + category
				+ "&apiKey=dbafd5d0212d40888d59582a73c7d054";
		ResponseEntity<NewsAPIDTO> response = restTemplate.getForEntity(url, NewsAPIDTO.class);
		Integer countNews = 0;
		for (ArticlesDTO article : response.getBody().getArticles()) {
			if (article.getPublishedAt().getDayOfMonth() == LocalDate.now().getDayOfMonth()) {
				countNews++;
			}
		}
		return countNews;
	}

}
