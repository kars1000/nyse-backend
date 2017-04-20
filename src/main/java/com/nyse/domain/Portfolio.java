package com.nyse.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.nyse.dto.PortfolioDTO;

@Entity
public class Portfolio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String companyName;
	private String symbol;
	private BigDecimal lastPrice;
	private long numberOfSharesOwned;

	public Portfolio() {
		super();
	}

	public Portfolio(PortfolioDTO dto) {
		this.companyName = dto.getCompanyName();
		this.symbol = dto.getSymbol();
		this.lastPrice = dto.getLastPrice();
		this.numberOfSharesOwned = dto.getNumberOfSharesOwned();
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public BigDecimal getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(BigDecimal lastPrice) {
		this.lastPrice = lastPrice;
	}

	public long getNumberOfSharesOwned() {
		return numberOfSharesOwned;
	}

	public void setNumberOfSharesOwned(long numberOfSharesOwned) {
		this.numberOfSharesOwned = numberOfSharesOwned;
	}

	public long getId() {
		return id;
	}

}
