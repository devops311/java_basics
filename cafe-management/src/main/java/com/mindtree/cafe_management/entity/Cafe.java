package com.mindtree.cafe_management.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cafe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cafeId;
	private String cafeName;
	private double revenue;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Manager manager;

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

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
}
