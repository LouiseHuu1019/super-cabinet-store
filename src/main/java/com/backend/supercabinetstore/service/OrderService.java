package com.backend.supercabinetstore.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.backend.supercabinetstore.bean.Order;
import com.backend.supercabinetstore.dao.OrderDao;
import com.backend.supercabinetstore.http.Response;

@Service
@Transactional
public class OrderService {
	@Autowired
	OrderDao orderDao;
	
	public Response addOrder(Order order) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		long num = timestamp.getTime();
		String ordernum = Long.toString(num);
		order.setOrderNum(ordernum);
		orderDao.save(order);
		return new Response(true);
	}
}
