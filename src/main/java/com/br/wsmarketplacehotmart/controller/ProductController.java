package com.br.wsmarketplacehotmart.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.wsmarketplacehotmart.dto.ProductDTO;
import com.br.wsmarketplacehotmart.model.Product;
import com.br.wsmarketplacehotmart.service.ProductService;
import com.br.wsmarketplacehotmart.view.ProductAlterForm;
import com.br.wsmarketplacehotmart.view.ProductForm;

@RestController
@RequestMapping("/api/wsmarkeplaehotmart")
public class ProductController {

	@Autowired
	public ProductService productService;

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
	public List<ProductDTO> listProductOrder() {
		Sort sort = createStaticSort();
		List<Product> productList = productService.listAllProduct(sort);
		return new ProductDTO().getProductList(productList);
	}

	public Sort createStaticSort() {
		String[] arrayOrdre = { "ranqueamento","nome","categoria" };
		return Sort.by(arrayOrdre);
	}
}
