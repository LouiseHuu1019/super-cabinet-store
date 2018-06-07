package com.backend.supercabinetstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.supercabinetstore.bean.Cabinets;

public interface CabinetDao extends JpaRepository<Cabinets, Integer> {

}
