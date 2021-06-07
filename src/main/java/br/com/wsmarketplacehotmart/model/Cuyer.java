package br.com.wsmarketplacehotmart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.wsmarketplacehotmart.dto.CuyerDTO;

@Entity
@Table(name = "tbcuyer")
//comprador
public class Cuyer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer identifier;
	private String name;

	public Cuyer(Integer identifier, String name) {
		this.identifier = identifier;
		this.name = name;
	}

	public Cuyer(CuyerDTO cuyer) {
		this.identifier = cuyer.getIdentifier();
		this.name = cuyer.getName();
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
