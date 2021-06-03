package com.br.wsmarketplacehotmart.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.br.wsmarketplacehotmart.dto.ProductDTO;
import com.br.wsmarketplacehotmart.view.ProductForm;

@Entity
@Table(name = "tbproduct")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "identifier")
	private Integer identifier;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "dateCreation", nullable = false)
	private LocalDate dateCreation = LocalDate.now();

	public Product() {
	}

	public Product(Integer identifier, String name, String description, LocalDate dateCreation) {
		this.identifier = identifier;
		this.name = name;
		this.description = description;
		this.dateCreation = dateCreation;
	}

	public Product(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Product(String name, String description, LocalDate dateCreation) {
		this.name = name;
		this.description = description;
		this.dateCreation = dateCreation;
	}

	public Product(ProductDTO productDTO) {
		this.identifier = productDTO.getIdentifier();
		this.name = productDTO.getName();
		this.description = productDTO.getDescription();
		this.dateCreation = productDTO.getDateCreation();
	}

	public Product(ProductForm productForm) {
		this.name = productForm.getName();
		this.description = productForm.getDescription();
		this.dateCreation = productForm.getDateCreation();
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

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

}
