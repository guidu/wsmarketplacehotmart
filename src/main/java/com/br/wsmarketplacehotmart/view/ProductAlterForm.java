package com.br.wsmarketplacehotmart.view;

import com.br.wsmarketplacehotmart.model.Product;

public class ProductAlterForm {
	private String name;
	private String description;
	private Integer identifierCategory;
	private String nameCategory;

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



	public Integer getIdentifierCategory() {
		return identifierCategory;
	}



	public void setIdentifierCategory(Integer identifierCategory) {
		this.identifierCategory = identifierCategory;
	}



	public String getNameCategory() {
		return nameCategory;
	}



	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}



	public Product convertProduct() {
		return new Product(name, description, identifierCategory, nameCategory);
	}
}
