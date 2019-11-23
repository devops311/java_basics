package com.mindtree.cafe_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.cafe_management.dto.CafeDto;
import com.mindtree.cafe_management.entity.Cafe;
import com.mindtree.cafe_management.service.ManagerService;

@RestController
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@GetMapping("/manager")
	public List<CafeDto> getCafesByManagerId(@RequestParam("managerId") int managerId){
		return managerService.getCafeByManagerId(managerId);
	}

}
