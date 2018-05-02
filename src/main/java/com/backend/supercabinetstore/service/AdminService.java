package com.backend.supercabinetstore.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.supercabinetstore.bean.Admin;
import com.backend.supercabinetstore.dao.AdminDao;
import com.backend.supercabinetstore.http.Response;

@Service
@Transactional
public class AdminService {

	@Autowired
	AdminDao adminDao;

	@Autowired
	PasswordEncoder passwordEncoder;

	public Response register(Admin user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		System.out.println(user);
		adminDao.save(user);
		return new Response(true);
	}
	
//	public Response changePassword(Admin user, Authentication authentication) {
//		if(user.getUsername().equals(authentication.getName()) || isAdmin(authentication.getAuthorities())) {
//			Admin u = adminDao.findByUsername(user.getUsername());
//			u.setPassword(passwordEncoder.encode(user.getPassword()));
//			adminDao.save(u);
//		}else {
//			return new Response(false);
//		}
//		return new Response(true);
//	}
	
//	public boolean isAdmin(Collection<? extends GrantedAuthority> profiles) {
//		boolean isAdmin = false;
//		for(GrantedAuthority profle: profiles) {
//			if(profle.getAuthority().equals("ROLE_ADMIN")) {
//				isAdmin = true;
//			}
//		};
//		return isAdmin;
//	}
	
	public Response deleteUser(int id) {
		if(adminDao.findOne(id) != null) {
			adminDao.delete(id);
			return new Response(true);
		}else {
			return new Response(false, "User is not found!");
		}
	}

}
