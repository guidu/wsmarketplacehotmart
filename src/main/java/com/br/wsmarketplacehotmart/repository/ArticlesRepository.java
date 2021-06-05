package com.br.wsmarketplacehotmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.wsmarketplacehotmart.model.Articles;

@Repository
public interface ArticlesRepository extends JpaRepository<Articles, Integer>{
}
