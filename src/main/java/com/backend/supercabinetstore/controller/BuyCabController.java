package com.backend.supercabinetstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.backend.supercabinetstore.bean.Buy_cab;
import com.backend.supercabinetstore.dao.BuyCabDao;
import com.backend.supercabinetstore.http.Response;

@RestController()
public class BuyCabController {
	@Autowired
	BuyCabDao buyCabDao;
	
	@GetMapping("/buycabs/{orderNum}")
	public List<Buy_cab> getAllCabs(@PathVariable int orderNum) {
		return buyCabDao.findByorders_id(orderNum);
	}
	
	@Transactional
	@DeleteMapping("/buycabs/{orderNum}")
	public Response deleteTheCabs(@PathVariable int orderNum) {
		buyCabDao.deleteByorders_id(orderNum);
		return new Response(true);
	}
}
