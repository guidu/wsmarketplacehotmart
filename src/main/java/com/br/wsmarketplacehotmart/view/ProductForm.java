package com.br.wsmarketplacehotmart.view;

import java.time.LocalDate;

import com.br.wsmarketplacehotmart.dto.ProductDTO;
import com.br.wsmarketplacehotmart.model.Product;
import com.br.wsmarketplacehotmart.service.ProductService;

public class ProductForm {
	private Integer identifier;
	private String name;
	private String description;
	private LocalDate dateCreation;

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

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public ProductDTO convertProductForm(ProductForm productForm) {
		return new ProductDTO(productForm);
	}	
	
	public ProductDTO convertProductDTO(ProductForm productForm) {
		return new ProductDTO(productForm);
	}	
	public Product convertProduct() {
		return new Product(name, description);
	}
}
