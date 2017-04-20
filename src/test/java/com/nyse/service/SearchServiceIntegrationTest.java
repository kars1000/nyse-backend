package com.nyse.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.nyse.NyseApplicationTests;

public class SearchServiceIntegrationTest extends NyseApplicationTests {

	@Autowired
	SearchService searchServiceImpl;

	@Test
	public void search_retrieveValuesFromYahooWebService_returnSymbol() {

		String ticker = "YHOO";


		assertTrue(searchServiceImpl.search(ticker).getTicker().equals(ticker));

	}

}
