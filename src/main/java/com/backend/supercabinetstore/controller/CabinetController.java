package com.backend.supercabinetstore.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.backend.supercabinetstore.bean.Cabinets;
import com.backend.supercabinetstore.dao.CabinetDao;
import com.backend.supercabinetstore.http.Response;
import com.backend.supercabinetstore.service.CabinetService;

@RestController()
public class CabinetController {
	
	@Autowired
	CabinetService cabinetService;
	
	@Autowired
	CabinetDao cabinetDao;
	
	public List<String> files = new ArrayList<String>();
	
	@GetMapping("/cabinets")
	public List<Cabinets> getCabinetsList() {
		return cabinetService.getCabinetsList();
	}
	
	@GetMapping("/getallfiles")
	public ResponseEntity<List<String>> getListFiles(Model model) {
		
		List<String> results = new ArrayList<String>();
		File[] pics = new File("cabinets").listFiles();
		for(File pic : pics) {
			results.add(pic.getName());
		}
		
		List<String> fileNames = results
				.stream().map(fileName -> MvcUriComponentsBuilder
						.fromMethodName(CabinetController.class, "getFile", fileName).build().toString())
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(fileNames);
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = cabinetService.loadFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
	
	@PostMapping("/cabinets")
	public Response addCabinet(@ModelAttribute Cabinets cabinet, @RequestParam("cabinet_image") MultipartFile file) {
		cabinet.setPic(file.getOriginalFilename());
		try {
			cabinetService.store(file);
			files.add(file.getOriginalFilename());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cabinetService.addCabinet(cabinet);
	}
	
}
