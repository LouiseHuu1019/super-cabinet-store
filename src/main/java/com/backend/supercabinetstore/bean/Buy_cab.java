package com.backend.supercabinetstore.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "BUY_CAB")
public class Buy_cab {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
	@SequenceGenerator(name = "SEQ", sequenceName = "BUYCAB_SEQ")
	private int buy_cab_id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orders_id")
	private Order orders;
	
	@Column
	private int cab_id;
	
	@Column
	private int cnt;

	public int getId() {
		return buy_cab_id;
	}

	public void setId(int id) {
		this.buy_cab_id = id;
	}

	public int getCab_id() {
		return cab_id;
	}

	public void setCab_id(int cab_id) {
		this.cab_id = cab_id;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public Buy_cab() {
		super();
	}

	public int getBuy_cab_id() {
		return buy_cab_id;
	}

	public void setBuy_cab_id(int buy_cab_id) {
		this.buy_cab_id = buy_cab_id;
	}

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}

	public Buy_cab(int buy_cab_id, Order orders, int cab_id, int cnt) {
		super();
		this.buy_cab_id = buy_cab_id;
		this.orders = orders;
		this.cab_id = cab_id;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "Buy_cab [buy_cab_id=" + buy_cab_id + ", orders=" + orders + ", cab_id=" + cab_id + ", cnt=" + cnt + "]";
	}
}
