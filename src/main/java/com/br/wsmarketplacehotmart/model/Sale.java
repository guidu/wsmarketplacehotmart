package com.br.wsmarketplacehotmart.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbsale")
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer identifier;
	@OneToOne
	private Seller saller;
	@OneToOne
	private Cuyer cuyer;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> product;

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
