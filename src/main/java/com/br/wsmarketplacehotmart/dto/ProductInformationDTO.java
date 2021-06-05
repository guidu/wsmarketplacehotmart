package com.br.wsmarketplacehotmart.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.br.wsmarketplacehotmart.model.Product;

public class ProductInformationDTO {
	private String searchTerm;
	private LocalDateTime currentDate;
	private List<ProductDetalheDTO> productsDetalhe = new ArrayList<ProductDetalheDTO>();

	public ProductInformationDTO() {
	}
	public ProductInformationDTO(String searchTerm, List<Product> product) {
		this.searchTerm = searchTerm;
		this.currentDate = LocalDateTime.now();
		for (Product prod : product) {
			this.productsDetalhe.add(new ProductDetalheDTO(prod));
		}
	}
//	for (Product p : sale.getProduct()) {
//		this.product.add(p);
//	}
	public String getSearchTerm() {
		return searchTerm;
	}
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	public LocalDateTime getCurrentDate() {
		return currentDate;
	}
	public List<ProductDetalheDTO> getProductsDetalhe() {
		return productsDetalhe;
	}

	public void setProductsDetalhe(List<ProductDetalheDTO> productsDetalhe) {
		this.productsDetalhe = productsDetalhe;
	}
}
