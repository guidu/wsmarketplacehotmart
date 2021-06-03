package com.br.wsmarketplacehotmart.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.br.wsmarketplacehotmart.model.Product;
import com.br.wsmarketplacehotmart.view.ProductForm;

public class ProductDTO {

	private Integer identifier;
	private String name;
	private String description;
	private LocalDate dateCreation;

	public ProductDTO() {
	}

	public ProductDTO(ProductForm productForm) {
		this.identifier = productForm.getIdentifier();
		this.name = productForm.getName();
		this.description = productForm.getDescription();
		this.dateCreation = productForm.getDateCreation();
	}

	public ProductDTO(Product product) {
		this.identifier = product.getIdentifier();
		this.name = product.getName();
		this.description = product.getDescription();
		this.dateCreation = product.getDateCreation();
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

	public List<ProductDTO> getProductList(List<Product> productList) {
		List<ProductDTO> productDTOlist = new ArrayList<ProductDTO>();
		for (Product product : productList) {
			productDTOlist.add(new ProductDTO(product));
		}
		return productDTOlist;
	}
}
