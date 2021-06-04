package com.br.wsmarketplacehotmart.view;

import java.time.LocalDateTime;

import com.br.wsmarketplacehotmart.model.Product;

public class ProductAlterForm {
	private String name;
	private String description;
	private LocalDateTime dateCreation;

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
	
	public Product convertProduct() {
		return new Product(name, description, dateCreation);
	}
}
