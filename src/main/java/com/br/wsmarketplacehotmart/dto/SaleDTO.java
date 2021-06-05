package com.br.wsmarketplacehotmart.dto;

import java.util.List;

import com.br.wsmarketplacehotmart.model.Cuyer;
import com.br.wsmarketplacehotmart.model.Product;
import com.br.wsmarketplacehotmart.model.Sale;
import com.br.wsmarketplacehotmart.model.Seller;

public class SaleDTO {
	private Integer identifier;
	private Seller saller;
	private Cuyer cuyer;
	private List<Product> product;

	public SaleDTO() {
	}

	public SaleDTO(Sale sale) {
		this.identifier = sale.getIdentifier();
		this.saller = sale.getSaller();
		this.cuyer = sale.getCuyer();
		for (Product p : sale.getProduct()) {
			this.product.add(p);
		}
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public Seller getSaller() {
		return saller;
	}

	public void setSaller(Seller saller) {
		this.saller = saller;
	}

	public Cuyer getCuyer() {
		return cuyer;
	}

	public void setCuyer(Cuyer cuyer) {
		this.cuyer = cuyer;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

}
