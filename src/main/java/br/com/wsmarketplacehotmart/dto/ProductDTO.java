package br.com.wsmarketplacehotmart.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.wsmarketplacehotmart.model.Product;
import br.com.wsmarketplacehotmart.view.ProductForm;

public class ProductDTO {

	private Integer identifier;
	private String name;
	private String description;
	private LocalDateTime dateCreation;
	private Integer identifierCategory;
	private String nameCategory;

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
		this.identifierCategory = product.getCategoryProduct().getIdentifier();
		this.nameCategory = product.getCategoryProduct().getName();
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

	public static Page<ProductDTO> convert(Page<Product> product) {
		return product.map(ProductDTO::new);
	}
}
