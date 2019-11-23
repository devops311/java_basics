package com.mindtree.cafe_management.service;

import java.util.List;

import com.mindtree.cafe_management.dto.CafeDto;

public interface CafeService {
	
	public CafeDto addCafe(CafeDto cafe);
	
	public List<CafeDto> getCafeByRevenue(double revenue);

}
