package com.br.wsmarketplacehotmart.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.br.wsmarketplacehotmart.model.Product;

public class ProductDetalheDTO {
	private Integer identifier;
	private String name;
	private String description;
	private LocalDateTime dateCreation;
	private long score;

	public ProductDetalheDTO() {
	}

	public ProductDetalheDTO(Product product) {
		this.identifier = product.getIdentifier();
		this.name = product.getName();
		this.description = product.getDescription();
		this.dateCreation = product.getDateCreation();
		this.score = product.getScore();
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public List<ProductDetalheDTO> getProductList(List<Product> productList) {
		List<ProductDetalheDTO> productDTOlist = new ArrayList<ProductDetalheDTO>();
		for (Product product : productList) {
			productDTOlist.add(new ProductDetalheDTO(product));
		}
		return productDTOlist;
	}
}
