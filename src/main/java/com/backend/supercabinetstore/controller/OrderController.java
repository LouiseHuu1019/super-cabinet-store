package com.backend.supercabinetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.backend.supercabinetstore.bean.Cabinets;
import com.backend.supercabinetstore.bean.Order;
import com.backend.supercabinetstore.bean.User;
import com.backend.supercabinetstore.http.Response;
import com.backend.supercabinetstore.service.OrderService;

@RestController()
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@PostMapping("/order")
	public Response addOrder(@RequestBody Order order) {
		order.getCab().forEach(cab -> cab.setOrders(order));
		return orderService.addOrder(order);
	}
}
