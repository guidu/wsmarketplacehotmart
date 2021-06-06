package com.br.wsmarketplacehotmart.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.wsmarketplacehotmart.dto.ArticlesDTO;
import com.br.wsmarketplacehotmart.dto.NewsAPIDTO;
import com.br.wsmarketplacehotmart.model.Product;
import com.br.wsmarketplacehotmart.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;

	public Product insert(Product product) {
		return productRepository.save(product);
	}
	public Product update(Product product, Integer identifier) {
		product.setIdentifier(identifier);
		return productRepository.saveAndFlush(product);
	}

	public void delete(Integer identifier) {
		productRepository.deleteById(identifier);
	}

	public List<Product> listAllProduct() {
		return productRepository.findAll();
	}
	
	public Page<Product> listAllProduct(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	public Optional<Product> findProduct(Integer identifier) {
		return productRepository.findById(identifier);
	}
	
	public Page<Product> findProduct(Integer identifier, Pageable pageable) {
		return productRepository.findByIdentifier(identifier, pageable);
	}
	/*
	 * Z = Quantidade de notícias da categoria do produto no dia corrente
	 */

	public long amountOfProductCategoryNews(String categoria) {
		return totalDailyNews(categoria);
	}

	private Integer totalDailyNews(String category) {
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
