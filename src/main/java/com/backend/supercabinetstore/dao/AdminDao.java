package com.backend.supercabinetstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.supercabinetstore.bean.Admin;

//@RestResource(path="users", rel="users")
public interface AdminDao extends JpaRepository<Admin, Integer>{
	Admin findByUsername(String username);
}
