package com.backend.supercabinetstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.backend.supercabinetstore.bean.Order;
import com.backend.supercabinetstore.dao.OrderDao;
import com.backend.supercabinetstore.http.Response;
import com.backend.supercabinetstore.service.OrderService;

@RestController()
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderDao orderDao;
	
	@PostMapping("/order")
	public Response addOrder(@RequestBody Order order) {
		order.getCab().forEach(cab -> cab.setOrders(order));
		return orderService.addOrder(order);
	}
	
	@GetMapping("/order")
	public List<Order> getAllOrders() {
		return orderDao.findAll();
	}
	
//	@DeleteMapping("/order/{id}")
	@Transactional
	@DeleteMapping("/order/{orderNum}")
	public Response deleteTheOrder(@PathVariable String orderNum) {
		orderDao.deleteByorderNum(orderNum);
		return new Response(true);
	}
}
