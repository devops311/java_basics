package com.mindtree.cafe_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.cafe_management.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {

}
