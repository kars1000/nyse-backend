package com.nyse.service;

import java.util.List;

import com.nyse.dto.PortfolioDTO;

public interface PortfolioService {

	/**
	 * 
	 * @param dto
	 * @return
	 */
	public boolean addPortfoilioData(PortfolioDTO dto);

	/**
	 * 
	 * @return
	 */
	public List<PortfolioDTO> listProfolioData();

	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteSymbol(long id);
}
