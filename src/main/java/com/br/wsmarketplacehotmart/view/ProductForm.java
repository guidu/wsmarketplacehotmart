package com.br.wsmarketplacehotmart.view;

import java.time.LocalDateTime;

import com.br.wsmarketplacehotmart.dto.ProductDTO;
import com.br.wsmarketplacehotmart.model.Product;

public class ProductForm {
	private Integer identifier;
	private String name;
	private String description;
	private LocalDateTime dateCreation;
	private Integer identifierCategory;
	private String nameCategory;

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

	public ProductDTO convertProductForm(ProductForm productForm) {
		return new ProductDTO(productForm);
	}

	public ProductDTO convertProductDTO(ProductForm productForm) {
		return new ProductDTO(productForm);
	}
	
	public Product convertProduct() {
		return new Product(name, description, identifierCategory, nameCategory);
	}
}
