package com.br.wsmarketplacehotmart.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ProductInformationDTO {
	private String name;
	private LocalDateTime dateCreation;
	private List<ProductDetalheDTO> productsDetalhe;

	public ProductInformationDTO() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<ProductDetalheDTO> getProductsDetalhe() {
		return productsDetalhe;
	}

	public void setProductsDetalhe(List<ProductDetalheDTO> productsDetalhe) {
		this.productsDetalhe = productsDetalhe;
	}

}
