package com.br.wsmarketplacehotmart.view;

import java.time.LocalDate;

import com.br.wsmarketplacehotmart.model.Product;

public class ProductAlterForm {
	private String name;
	private String description;
	private LocalDate dateCreation;

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

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public Product convertProduct() {
		return new Product(name, description, dateCreation);
	}
}
