package com.backend.supercabinetstore.dao;

import java.util.List;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.backend.supercabinetstore.bean.Cabinets;
import com.backend.supercabinetstore.http.Response;

@Repository
public class CabinetDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate npjt;
	
	public List<Cabinets> getCabinetsList() {
		return null;
	}

	public Response addCabinet(Cabinets cabinet) {
		String sql_id = "select MAX(id) from cabinets where id is not null";
		System.out.println(sql_id);
		Integer id;
		try {
			id = jdbcTemplate.queryForObject(sql_id, Integer.class);
			System.out.println(id);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		
//		String sql = String.format("insert into cabinets values('%s', '%s', '%s', '%s', '%s', '%s')", 
//				cabinet.getCab_desc(), 
//				cabinet.getCab_name(),
//				cabinet.getCnt_ord(),
//				cabinet.getOdate(),
//				cabinet.getPic(),
//				cabinet.getPrice()
//				);
//		System.out.println(sql);
//		jdbcTemplate.execute(sql);
		return null;
	}

}
