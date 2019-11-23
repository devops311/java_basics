package com.mindtree.cafe_management.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ManagerDto {

	private int managerId;
	private String managerName;
	private double salary;
	@JsonIgnoreProperties("manager")
	private List<CafeDto> cafes;

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<CafeDto> getCafes() {
		return cafes;
	}

	public void setCafes(List<CafeDto> cafes) {
		this.cafes = cafes;
	}

	@Override
	public String toString() {
		return "ManagerDto [managerId=" + managerId + ", managerName=" + managerName + ", salary=" + salary + "]";
	}

}
