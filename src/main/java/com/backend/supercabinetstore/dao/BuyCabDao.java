package com.backend.supercabinetstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.supercabinetstore.bean.Buy_cab;

public interface BuyCabDao extends JpaRepository<Buy_cab, Integer>{
	List<Buy_cab> findByorders_id(int id);
	
	void deleteByorders_id(int id);
}
