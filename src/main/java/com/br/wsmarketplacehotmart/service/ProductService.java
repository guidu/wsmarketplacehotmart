package com.br.wsmarketplacehotmart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.wsmarketplacehotmart.model.Product;
import com.br.wsmarketplacehotmart.repository.ProductRepository;


@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public Product insert(Product product) {
		return productRepository.save(product);
	}

	public void delete(Product product) {
		productRepository.delete(product);
	}

	public Optional<Product> listProduct(Product product) {
		return productRepository.findById(product.getIdentifier());
	}

	public List<Product> listAllProduct() {
		return productRepository.findAll();
	}

	public Optional<Product> findProduct(Integer identifier) {
		return productRepository.findById(identifier);
	}
}
