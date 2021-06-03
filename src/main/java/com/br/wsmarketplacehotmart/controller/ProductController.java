package com.br.wsmarketplacehotmart.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.wsmarketplacehotmart.dto.ProductDTO;
import com.br.wsmarketplacehotmart.model.Product;
import com.br.wsmarketplacehotmart.service.ProductService;
import com.br.wsmarketplacehotmart.view.ProductForm;

@RestController
@RequestMapping("/api/wsmarkeplaehotmart")
public class ProductController {
	
	@Autowired
	public ProductService productService;
	
	@PostMapping("/insert")
	public ResponseEntity<ProductDTO> create(@RequestBody ProductForm productForm, UriComponentsBuilder uriComponentsBuilder) {
		Product product = productForm.convertProduct();
		productService.insert(product);	
		URI uri = uriComponentsBuilder.path("/productlist/{id}").buildAndExpand(product.getIdentifier()).toUri();
		return ResponseEntity.created(uri).body(new ProductDTO(product));
	}
	
	@GetMapping("/find/{identifier}")
	public ProductDTO find(@PathVariable Integer identifier,UriComponentsBuilder uriComponentsBuilder) {
		Optional<Product> product = productService.findProduct(identifier);
		return new ProductDTO(product.get());
	}
}
