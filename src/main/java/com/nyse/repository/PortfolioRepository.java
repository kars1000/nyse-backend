package com.nyse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nyse.domain.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
	
	
	

}
