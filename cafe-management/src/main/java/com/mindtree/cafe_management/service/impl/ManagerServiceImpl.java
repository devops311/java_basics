package com.mindtree.cafe_management.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.cafe_management.dto.CafeDto;
import com.mindtree.cafe_management.entity.Cafe;
import com.mindtree.cafe_management.repository.ManagerRepository;
import com.mindtree.cafe_management.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {
	
	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
	CafeServiceImpl cafeServiceImpl;

	@Override
	public List<CafeDto> getCafeByManagerId(int managerId) {
		List<Cafe> cafes = managerRepository.findById(managerId).get().getCafes();
		return cafes.stream().map(e->cafeServiceImpl.convertEntityToDto(e)).collect(Collectors.toList());
	}

}
