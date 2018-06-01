package com.backend.supercabinetstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.supercabinetstore.bean.User;

//@RestResource(path="users", rel="users")
public interface UserDao extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
