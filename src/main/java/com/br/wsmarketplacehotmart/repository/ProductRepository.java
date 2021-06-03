package com.br.wsmarketplacehotmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.wsmarketplacehotmart.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
