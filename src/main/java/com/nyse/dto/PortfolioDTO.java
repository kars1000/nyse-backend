package com.nyse.dto;

import java.math.BigDecimal;

import com.nyse.domain.Portfolio;

public class PortfolioDTO {

	private String companyName;
	private String symbol;
	private BigDecimal lastPrice;
	private long numberOfSharesOwned;
	private long id;

	private BigDecimal marketValue;

	public PortfolioDTO(Portfolio e) {
		this.companyName = e.getCompanyName();
		this.symbol = e.getSymbol();
		this.lastPrice = e.getLastPrice();
		this.numberOfSharesOwned = e.getNumberOfSharesOwned();
		this.id = e.getId();
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

	public PortfolioDTO() {
		super();
	}

	public BigDecimal getMarketValue() {
		return marketValue.multiply(new BigDecimal(numberOfSharesOwned));
	}

	public void setMarketValue(BigDecimal price) {

		this.marketValue = price != null ? price : BigDecimal.ZERO;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
