package com.br.wsmarketplacehotmart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.wsmarketplacehotmart.model.Articles;
import com.br.wsmarketplacehotmart.repository.ArticlesRepository;

@Service
public class ArticlesService {
	@Autowired
	public ArticlesRepository articlesRepository;
	public Articles salve(Articles articles) {
		return articlesRepository.save(articles);
	}
}
