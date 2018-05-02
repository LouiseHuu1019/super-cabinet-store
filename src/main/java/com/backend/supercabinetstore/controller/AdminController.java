package com.backend.supercabinetstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaobin.Yaobinbusinessbackend.bean.User;
import com.yaobin.Yaobinbusinessbackend.dao.UserDao;
import com.yaobin.Yaobinbusinessbackend.http.Response;
import com.yaobin.Yaobinbusinessbackend.service.UserService;

@RestController()
@RequestMapping("/users")
public class AdminController {
	
	@Autowired
	AdminDao userDao;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping
	public List<User> getUsers(){
		return userDao.findAll();
	}
	
	@PostMapping
	public Response addUser(@RequestBody User user) {
		return userService.register(user);
	}
	
	@DeleteMapping("/{id}")
	public Response deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}
	
}
