package com.backend.supercabinetstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.supercabinetstore.bean.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {
	
	void deleteByid(int id);
}
