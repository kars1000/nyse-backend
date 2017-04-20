package com.nyse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nyse.dto.SearchDTO;
import com.nyse.dto.YahooResponseWrapper;

@Service
public class SearchServiceImpl implements SearchService {

	private RestTemplate restTemplate;

	@Autowired
	public SearchServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public SearchDTO search(String ticker) {

		// https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22YHOO%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys

		String env = "store://datatables.org/alltableswithkeys";
		String symbolString = "(\"" + ticker + "\")";
		String fmt = "json";
		String queryStr = "select * from yahoo.finance.quotes where symbol in " + symbolString;
		String restJsonUrl = "http://query.yahooapis.com/v1/public/yql?q={qid}&format={fmt}&env={senv}";
		YahooResponseWrapper response = restTemplate.getForObject(restJsonUrl, YahooResponseWrapper.class, queryStr,
				fmt, env);
		return new SearchDTO(response);
	}

}
