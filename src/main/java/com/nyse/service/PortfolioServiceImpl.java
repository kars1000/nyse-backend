package com.nyse.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyse.domain.Portfolio;
import com.nyse.dto.PortfolioDTO;
import com.nyse.dto.SearchDTO;
import com.nyse.repository.PortfolioRepository;

@Service
@Transactional
public class PortfolioServiceImpl implements PortfolioService {

	private PortfolioRepository portfolioRepository;
	private SearchService searchService;

	@Autowired
	public PortfolioServiceImpl(PortfolioRepository portfolioRepository, SearchService searchService) {

		this.portfolioRepository = portfolioRepository;
		this.searchService = searchService;
	}

	@Override
	public boolean addPortfoilioData(PortfolioDTO dto) {

		if (portfolioRepository.count() >= 5) {
			return false;
		} else {
			SearchDTO search = searchService.search(dto.getSymbol());
			dto.setLastPrice(search.getPrice());
			Portfolio portfolio = new Portfolio(dto);

			portfolioRepository.save(portfolio);
		}

		return true;
	}

	@Override
	public List<PortfolioDTO> listProfolioData() {

		List<PortfolioDTO> portfolioDTOs = portfolioRepository.findAll().stream().map(e -> new PortfolioDTO(e))
				.collect(Collectors.toList());

		for (PortfolioDTO p : portfolioDTOs) {
			SearchDTO search = searchService.search(p.getSymbol());
			p.setMarketValue(search.getPrice());
		}

		return portfolioDTOs;
	}

	@Override
	public boolean deleteSymbol(long id) {
		portfolioRepository.delete(id);
		return true;
	}

}
