package com.br.wsmarketplacehotmart.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.br.wsmarketplacehotmart.model.Product;

public class ProductDetailsDTO {
	private Integer identifier;
	private String name;
	private String description;
	private LocalDateTime dateCreation;
	private Integer score;

	public ProductDetailsDTO(Product product) {
		this.identifier = product.getIdentifier();
		this.name = product.getName();
		this.description = product.getDescription();
		this.dateCreation = product.getDateCreation();	}

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

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	public List<ProductDetailsDTO> getProductList(List<Product> productList) {
		List<ProductDetailsDTO> productDTOlist = new ArrayList<ProductDetailsDTO>();
		for (Product product : productList) {
			productDTOlist.add(new ProductDetailsDTO(product));
		}
		return productDTOlist;
	}
}
