package com.mindtree.cafe_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.cafe_management.dto.CafeDto;
import com.mindtree.cafe_management.entity.Cafe;
import com.mindtree.cafe_management.service.CafeService;

@RestController
public class CafeController {
	
	@Autowired
	private CafeService cafeService;
	
	@PostMapping("/cafe")
	public CafeDto addCafe(@RequestBody CafeDto cafedto) {
		CafeDto savedDto =  cafeService.addCafe(cafedto);
		return savedDto;
	}
	
	@GetMapping("/cafe")
	public List<CafeDto> getCafeByRevenue(@RequestParam("revenue") double revenue){
		return cafeService.getCafeByRevenue(revenue);
	}

}
