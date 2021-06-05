package com.br.wsmarketplacehotmart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.br.wsmarketplacehotmart.dto.SourceDTO;

@Entity
@Table(name = "tbsource")
public class Source {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer identifier;
	private String id;
	@Column(name = "name")
	private String name;

	public Source() {
	}

	public Source(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public Source(SourceDTO source) {
		this.id = source.getId();
		this.name = source.getName();
	}
	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
