package br.com.wsmarketplacehotmart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.wsmarketplacehotmart.dto.SellerDTO;

//vendedor
@Entity
@Table(name = "tbsaller")
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer identifier;
	private String name;

	public Seller() {
	}

	public Seller(Integer identifier, String name) {
		this.identifier = identifier;
		this.name = name;
	}

	public Seller(SellerDTO sallerDTO) {
		this.identifier = sallerDTO.getIdentifier();
		this.name = sallerDTO.getName();
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

}
