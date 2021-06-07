package br.com.wsmarketplacehotmart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.wsmarketplacehotmart.model.Product;


public interface ProductService {

	public Product insert(Product product);
	
	public Product update(Product product);

	public void delete(Integer identifier);

	public List<Product> listAllProduct();
	
	public Page<Product> listAllProduct(Pageable pageable);

	public Optional<Product> findProduct(Integer identifier);
	
	public Page<Product> findProduct(Integer identifier, Pageable pageable);
}
