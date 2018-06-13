package com.backend.supercabinetstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.supercabinetstore.bean.Order;
import com.backend.supercabinetstore.bean.UserProfile;
import com.backend.supercabinetstore.dao.CabinetDao;
import com.backend.supercabinetstore.dao.OrderDao;
import com.backend.supercabinetstore.http.Response;

@Service
@Transactional
public class OrderService {
	@Autowired
	OrderDao orderDao;
	
	public Response addOrder(Order order) {
		orderDao.save(order);
		
		return new Response(true);
	}
	
}
