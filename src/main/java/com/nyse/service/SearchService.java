package com.nyse.service;

import com.nyse.dto.SearchDTO;

public interface SearchService {

	/***
	 * 
	 * @param ticker
	 * @return
	 */
	public SearchDTO search(String ticker);

}
