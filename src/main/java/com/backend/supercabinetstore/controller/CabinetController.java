package com.backend.supercabinetstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.supercabinetstore.bean.Cabinets;
import com.backend.supercabinetstore.dao.CabinetDao;
import com.backend.supercabinetstore.http.Response;
import com.backend.supercabinetstore.service.CabinetService;

@RestController()
@RequestMapping("/cabinets")
public class CabinetController {
	
	@Autowired
	CabinetService cabinetService;
	
	@Autowired
	CabinetDao cabinetDao;
	
	@GetMapping
	public List<Cabinets> getCabinetsList() {
		return cabinetService.getCabinetsList();
	}
	
	@PostMapping
	public Response addCabinet(@RequestBody Cabinets cabinet) {
		return cabinetService.addCabinet(cabinet);
	}
	
}
