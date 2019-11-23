package com.mindtree.cafe_management.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Manager {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int managerId;
	private String managerName;
	private double salary;
	
	@OneToMany(mappedBy="manager")
	List<Cafe> cafes;
	
	public List<Cafe> getCafes() {
		return cafes;
	}
	public void setCafes(List<Cafe> cafes) {
		this.cafes = cafes;
	}
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
	

}
