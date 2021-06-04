package com.br.wsmarketplacehotmart.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Enumerated()
	@Column(name = "note")
	private AssessProductEnum assessProductEnum;
	
	@Column(name = "dateassessment")
	private LocalDateTime dateAssessment;

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

	public LocalDateTime getDateAssessment() {
		return dateAssessment;
	}

	public void setDateAssessment(LocalDateTime dateAssessment) {
		this.dateAssessment = dateAssessment;
	}
	
}
