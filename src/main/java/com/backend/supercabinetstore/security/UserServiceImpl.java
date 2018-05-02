package com.backend.supercabinetstore.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.supercabinetstore.bean.Admin;
import com.backend.supercabinetstore.dao.AdminDao;

@Service
public class UserServiceImpl implements UserDetailsService {
	
	@Autowired
	AdminDao adminDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin user = adminDao.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}
		return user;
	}

}
