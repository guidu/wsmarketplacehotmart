package com.br.wsmarketplacehotmart.async;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.wsmarketplacehotmart.dto.ArticlesDTO;
import com.br.wsmarketplacehotmart.dto.NewsAPIDTO;
import com.br.wsmarketplacehotmart.model.HistoryExec;
import com.br.wsmarketplacehotmart.service.HistoryExecService;

@Service
public class AsyncNewsAPIService {
	@Autowired
	private HistoryExecService historyExecService;

	@Async
	public void asyncExecucaoPerfil() {

		RestTemplate restTemplate = new RestTemplate();
		String url = "https://newsapi.org/v2/top-headlines?country=br&apiKey=dbafd5d0212d40888d59582a73c7d054";
		ResponseEntity<NewsAPIDTO> response = restTemplate.getForEntity(url, NewsAPIDTO.class);
		List<ArticlesDTO> listArticles = response.getBody().getArticles();
		Integer countNews = 0;
		for (ArticlesDTO article : listArticles) {
			if (article.getPublishedAt().getDayOfMonth() == LocalDate.now().getDayOfMonth()) {
				countNews++;
			}
		}
		historyExecService.salve(new HistoryExec(countNews));
			

	}
}
