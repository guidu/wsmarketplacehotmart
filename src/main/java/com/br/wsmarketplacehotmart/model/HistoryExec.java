package com.br.wsmarketplacehotmart.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbhistoryexec")
public class HistoryExec {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "identifier")
	private Integer identifier;
	@Column(name = "amountofnews")
	private Integer amountOfNews;
	@Column(name = "datetimexxecution")
	private LocalDateTime datetimeExecution = LocalDateTime.now();

	public HistoryExec() {
	}

	public HistoryExec(Integer amountOfNews) {
		this.amountOfNews = amountOfNews;
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public Integer getAmountOfNews() {
		return amountOfNews;
	}

	public void setAmountOfNews(Integer amountOfNews) {
		this.amountOfNews = amountOfNews;
	}

	public LocalDateTime getDatetimeExecution() {
		return datetimeExecution;
	}

	public void setDatetimeExecution(LocalDateTime datetimeExecution) {
		this.datetimeExecution = datetimeExecution;
	}

}
