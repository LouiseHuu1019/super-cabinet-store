package com.backend.supercabinetstore.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "admin_user")
public class Cabinets {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
	@SequenceGenerator(name = "SEQ", sequenceName = "ADMIN_USER_SEQ")
	private int id;
	@Column(name = "products_name", unique = true, nullable = false)
	private String products_name;
	@Column(name = "products_desc", nullable = false)
	private String products_desc;
	@Column(name = "price", nullable = false)
	private double price;
	
	
}
