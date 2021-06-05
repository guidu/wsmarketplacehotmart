package com.br.wsmarketplacehotmart.view;

import java.util.List;

import com.br.wsmarketplacehotmart.dto.CuyerDTO;
import com.br.wsmarketplacehotmart.dto.ProductDTO;
import com.br.wsmarketplacehotmart.dto.SellerDTO;
import com.br.wsmarketplacehotmart.model.Sale;

public class SaletForm {
	private Integer identifier;
	private SellerDTO saller;
	private CuyerDTO cuyer;
	private List<ProductDTO> product;

	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public SellerDTO getSaller() {
		return saller;
	}

	public void setSaller(SellerDTO saller) {
		this.saller = saller;
	}

	public CuyerDTO getCuyer() {
		return cuyer;
	}

	public void setCuyer(CuyerDTO cuyer) {
		this.cuyer = cuyer;
	}

	public List<ProductDTO> getProduct() {
		return product;
	}

	public void setProduct(List<ProductDTO> product) {
		this.product = product;
	}

	public Sale convertSale() {
		return new Sale(saller, cuyer, product);
	}

}
