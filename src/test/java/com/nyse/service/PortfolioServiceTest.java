package com.nyse.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.nyse.dto.PortfolioDTO;
import com.nyse.dto.SearchDTO;
import com.nyse.repository.PortfolioRepository;

public class PortfolioServiceTest {

	private PortfolioRepository portfolioRepository;
	private PortfolioServiceImpl portfolioService;
	private SearchServiceImpl searchService;

	@Before
	public void setUp() {

		portfolioRepository = Mockito.mock(PortfolioRepository.class);
		searchService = Mockito.mock(SearchServiceImpl.class);
		portfolioService = new PortfolioServiceImpl(portfolioRepository, searchService);

	}

	@Test
	public void addPortfoilioData_validateUserIsNotAllowedMoreThan5Entries_returnsFalse() {

		Mockito.when(portfolioRepository.count()).thenReturn(5l);

		boolean val = portfolioService.addPortfoilioData(null);

		assertFalse(val);

	}

	@Test
	public void addPortfoilioData_validateUserIsAllowedMoreThan5Entries_returnsTrue() {

		Mockito.when(portfolioRepository.count()).thenReturn(4l);
		Mockito.when(searchService.search(Mockito.anyString())).thenReturn(new SearchDTO());

		boolean val = portfolioService.addPortfoilioData(new PortfolioDTO());

		assertTrue(val);

	}

}
