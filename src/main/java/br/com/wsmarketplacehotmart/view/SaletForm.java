package br.com.wsmarketplacehotmart.view;

import java.util.List;

import br.com.wsmarketplacehotmart.dto.CuyerDTO;
import br.com.wsmarketplacehotmart.dto.ProductDTO;
import br.com.wsmarketplacehotmart.dto.SellerDTO;
import br.com.wsmarketplacehotmart.model.Sale;

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
