package com.backend.supercabinetstore.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.backend.supercabinetstore.bean.Cabinets;
import com.backend.supercabinetstore.dao.CabinetDao;
import com.backend.supercabinetstore.http.Response;

@Service
@Transactional
public class CabinetService {

	@Autowired
	CabinetDao cabinetDao;

	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private final Path rootLocation = Paths.get("cabinets");
	
	public List<Cabinets> getCabinetsList() {
		return cabinetDao.findAll();
	}
	
	public Cabinets getOneCab(String cab_name) {
		return null;
	}

	public Response addCabinet(Cabinets cabinet) {
		cabinet.setOdate(new Timestamp(System.currentTimeMillis()));
		cabinetDao.save(cabinet);
		return new Response(true);
	}
	
	public void store(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
			System.out.println(rootLocation);
		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
	}

	public Resource loadFile(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}

	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}

	public void init() {
		try {
			Files.createDirectory(rootLocation);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage!");
		}
	}
}
