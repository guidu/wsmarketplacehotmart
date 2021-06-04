package com.br.wsmarketplacehotmart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.br.wsmarketplacehotmart.enums.AssessProductEnum;

@Entity
@Table(name = "tbassesproduct")
public class AssessProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name =  "identifier")
	private Integer identifier;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Enumerated()
	@Column(name = "note")
	private AssessProductEnum assessProductEnum;

	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public AssessProductEnum getAssessProductEnum() {
		return assessProductEnum;
	}

	public void setAssessProductEnum(AssessProductEnum assessProductEnum) {
		this.assessProductEnum = assessProductEnum;
	}
	
}
