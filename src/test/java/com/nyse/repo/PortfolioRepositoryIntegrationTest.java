package com.nyse.repo;

import org.springframework.beans.factory.annotation.Autowired;

import com.nyse.NyseApplicationTests;
import com.nyse.repository.PortfolioRepository;

public class PortfolioRepositoryIntegrationTest extends NyseApplicationTests {

	@Autowired
	private PortfolioRepository portfolioRepository;

	public void test() {

		portfolioRepository.findAll();
	}

}
