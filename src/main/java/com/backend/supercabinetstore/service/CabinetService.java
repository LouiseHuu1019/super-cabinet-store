package com.backend.supercabinetstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.supercabinetstore.bean.Cabinets;
import com.backend.supercabinetstore.dao.CabinetDao;
import com.backend.supercabinetstore.http.Response;

@Service
@Transactional
public class CabinetService {

	@Autowired
	CabinetDao cabinetDao;

	public List<Cabinets> getCabinetsList() {
		return cabinetDao.getCabinetsList();
		
	}

	public Response addCabinet(Cabinets cabinet) {
		return cabinetDao.addCabinet(cabinet);
	}
	
}
