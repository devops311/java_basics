package com.mindtree.cafe_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.cafe_management.entity.Cafe;

@Repository
public interface CafeRepository extends JpaRepository<Cafe, Integer> {
	public List<Cafe> getByRevenueGreaterThan(double revenue);
}
