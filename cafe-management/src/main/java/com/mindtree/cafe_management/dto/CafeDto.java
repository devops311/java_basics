package com.mindtree.cafe_management.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class CafeDto {

	private int cafeId;
	private String cafeName;
	private double revenue;
	@JsonIgnoreProperties("cafes")
	private ManagerDto manager;
	public ManagerDto getManager() {
		return manager;
	}
	public void setManager(ManagerDto manager) {
		this.manager = manager;
	}
	public int getCafeId() {
		return cafeId;
	}
	public void setCafeId(int cafeId) {
		this.cafeId = cafeId;
	}
	public String getCafeName() {
		return cafeName;
	}
	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	@Override
	public String toString() {
		return "CafeDto [cafeId=" + cafeId + ", cafeName=" + cafeName + ", revenue=" + revenue + "]";
	}
	
	
}
