package com.backend.supercabinetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.supercabinetstore.bean.User;
import com.backend.supercabinetstore.http.Response;
import com.backend.supercabinetstore.service.UserService;

@RestController()
//@RequestMapping("/users")
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/admin")
	public Response addUser(@RequestBody User user) {
		return userService.registerAdm(user);
	}
}
