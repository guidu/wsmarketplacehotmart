package com.br.wsmarketplacehotmart.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.br.wsmarketplacehotmart.dto.ArticlesDTO;

@Entity
@Table(name = "tbarticles")
public class Articles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer identifier;
	@OneToOne(cascade = CascadeType.ALL)
	private Source source;
	@Column(name = "author")
	private String author;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "url")
	private String url;
	@Column(name = "urltoimage")
	private String urlToImage;
	@Column(name = "publishedat")
	private LocalDateTime publishedAt;
	@Column(name = "content")
	private String content;

	public Articles() {
	}

	public Articles(Source source, String author, String title, String description, String url, String urlToImage,
			LocalDateTime publishedAt, String content) {
		this.source = source;
		this.author = author;
		this.title = title;
		this.description = description;
		this.url = url;
		this.urlToImage = urlToImage;
		this.publishedAt = publishedAt;
		this.content = content;
	}
	
	public Articles(ArticlesDTO a) {
		this.source = new Source(a.getSource());
		this.author = a.getAuthor();
		this.title = a.getTitle();
		this.description = a.getDescription();
		this.url = a.getUrl();
		this.urlToImage = a.getUrlToImage();
		this.publishedAt = a.getPublishedAt();
		this.content = a.getContent();
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlToImage() {
		return urlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	public LocalDateTime getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(LocalDateTime publishedAt) {
		this.publishedAt = publishedAt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
