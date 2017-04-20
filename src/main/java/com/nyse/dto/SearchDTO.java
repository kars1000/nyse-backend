package com.nyse.dto;

import java.math.BigDecimal;

public class SearchDTO {

	private String ticker;
	private BigDecimal price;

	public SearchDTO(YahooResponseWrapper response) {
		ticker = response.getQuery().getResults().getQuote().getSymbol();
		price = response.getQuery().getResults().getQuote().getAsk();

	}

	public String getTicker() {
		return ticker;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public SearchDTO() {
		super();
	}

}
