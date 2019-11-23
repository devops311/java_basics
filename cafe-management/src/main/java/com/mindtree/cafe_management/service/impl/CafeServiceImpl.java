package com.mindtree.cafe_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.cafe_management.dto.CafeDto;
import com.mindtree.cafe_management.entity.Cafe;
import com.mindtree.cafe_management.repository.CafeRepository;
import com.mindtree.cafe_management.service.CafeService;

@Service
public class CafeServiceImpl implements CafeService {

	@Autowired
	private CafeRepository cafeRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public CafeDto addCafe(CafeDto cafeDto) {
		Cafe cafe = convertDtoToEntity(cafeDto);
		Cafe cafe1 = cafeRepository.save(cafe);
		CafeDto cafeDto1 = convertEntityToDto(cafe1);
		return cafeDto1;
	}
	@Override
	public List<CafeDto> getCafeByRevenue(double revenue) {
		List<Cafe> cafes = cafeRepository.findAll();
		List<Cafe> revenueCafes = new ArrayList<>();
//		cafes.forEach(e->{
//			if(e.getRevenue()>=revenue) {
//				revenueCafes.add(e);
//			}
//		});
//		return revenueCafes;
		revenueCafes =  cafes.stream().filter(e->e.getRevenue()>=revenue).collect(Collectors.toList());
		return revenueCafes.stream().map(e->convertEntityToDto(e)).collect(Collectors.toList());
	}
	
	public Cafe convertDtoToEntity(CafeDto cafeDto) {
		return modelMapper.map(cafeDto, Cafe.class);
	}
	public CafeDto convertEntityToDto(Cafe cafe){
		return modelMapper.map(cafe, CafeDto.class);
	}

}
