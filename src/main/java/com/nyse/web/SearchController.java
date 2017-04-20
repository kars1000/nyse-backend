package com.nyse.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nyse.dto.SearchDTO;
import com.nyse.service.SearchService;

@RestController
@RequestMapping("/search")
@CrossOrigin
public class SearchController {

	private SearchService searchService;

	@Autowired
	public SearchController(SearchService searchService) {

		this.searchService = searchService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public SearchDTO searchSymbol(String symbol) {
		return searchService.search(symbol);
	}

}
