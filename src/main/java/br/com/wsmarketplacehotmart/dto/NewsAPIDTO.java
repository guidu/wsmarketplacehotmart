package br.com.wsmarketplacehotmart.dto;

import java.util.List;

public class NewsAPIDTO {
	private String status;
	private Integer totalResults;
	private List<ArticlesDTO> articles;

	public NewsAPIDTO() {
	}

	public NewsAPIDTO(String status, Integer totalResults, List<ArticlesDTO> articles) {
		this.status = status;
		this.totalResults = totalResults;
		this.articles = articles;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}

	public List<ArticlesDTO> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticlesDTO> articles) {
		this.articles = articles;
	}

}
