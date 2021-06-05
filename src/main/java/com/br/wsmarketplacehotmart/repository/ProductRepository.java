package com.br.wsmarketplacehotmart.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.wsmarketplacehotmart.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	public Page<Product> findByIdentifier(Integer identifier, Pageable pageable);

}
