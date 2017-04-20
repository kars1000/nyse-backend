package com.nyse.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YahooResponseWrapper {

	private Query query;

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Query {

	private String created;

	public Result results;

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public Result getResults() {
		return results;
	}

	public void setResults(Result results) {
		this.results = results;
	}

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Result {

	private Quote quote;

	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Quote {

	public String Symbol;
	public String LastTradeDate;
	public String Open;
	public String PreviousClose;
	public BigDecimal Ask;

	public String getSymbol() {
		return Symbol;
	}

	public void setSymbol(String symbol) {
		Symbol = symbol;
	}

	public String getLastTradeDate() {
		return LastTradeDate;
	}

	public void setLastTradeDate(String lastTradeDate) {
		LastTradeDate = lastTradeDate;
	}

	public String getOpen() {
		return Open;
	}

	public void setOpen(String open) {
		Open = open;
	}

	public String getPreviousClose() {
		return PreviousClose;
	}

	public void setPreviousClose(String previousClose) {
		PreviousClose = previousClose;
	}

	public BigDecimal getAsk() {
		return Ask;
	}

	public void setAsk(BigDecimal ask) {
		Ask = ask;
	}

}
