package com.mindtree.cafe_management.service;

import java.util.List;

import com.mindtree.cafe_management.dto.CafeDto;

public interface ManagerService {
	
	public List<CafeDto> getCafeByManagerId(int managerId); 

}
