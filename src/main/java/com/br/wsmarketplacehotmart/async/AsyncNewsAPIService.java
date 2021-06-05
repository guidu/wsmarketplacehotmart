package com.br.wsmarketplacehotmart.async;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.wsmarketplacehotmart.dto.ArticlesDTO;
import com.br.wsmarketplacehotmart.dto.NewsAPIDTO;
import com.br.wsmarketplacehotmart.model.Articles;
import com.br.wsmarketplacehotmart.service.ArticlesService;

@Service
public class AsyncNewsAPIService {
	
	@Autowired
	public ArticlesService articlesService;

	@Async
	public void asyncExecucaoPerfil() {

		RestTemplate restTemplate = new RestTemplate();
		String url = "https://newsapi.org/v2/top-headlines?country=br&apiKey=dbafd5d0212d40888d59582a73c7d054";
		ResponseEntity<NewsAPIDTO> response = restTemplate.getForEntity(url, NewsAPIDTO.class);
		ArticlesDTO articlesDTO = new ArticlesDTO(); 
		List<Articles> articles = articlesDTO.getListArticles(response.getBody().getArticles());
		articles.forEach(s -> {
			articlesService.salve(s);
		});
	}

}
