package com.nyse.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nyse.dto.PortfolioDTO;
import com.nyse.service.PortfolioService;

@RestController
@RequestMapping("/portfolio")
@CrossOrigin
public class PortfolioController {

	private PortfolioService portfolioService;

	@Autowired
	public PortfolioController(PortfolioService portfolioService) {
		this.portfolioService = portfolioService;

	}

	@RequestMapping(method = RequestMethod.POST)
	public boolean addDataToPortfolio(@RequestBody PortfolioDTO dto) {
		return portfolioService.addPortfoilioData(dto);

	}

	@RequestMapping(method = RequestMethod.GET)
	public List<PortfolioDTO> listPortfolioData() {
		return portfolioService.listProfolioData();

	}

	@RequestMapping(method = RequestMethod.DELETE)
	public boolean deleteFromProfile(long id) {
		return portfolioService.deleteSymbol(id);

	}

}
