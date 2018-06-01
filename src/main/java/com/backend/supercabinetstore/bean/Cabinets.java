package com.backend.supercabinetstore.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cabinets")
public class Cabinets {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
	@SequenceGenerator(name = "SEQ", sequenceName = "CAB_SEQ")
	private int id;
	
	@Column(name = "cab_name", unique = true, nullable = false)
	private String cab_name;
	
	@Column(name = "cab_desc", nullable = false)
	private String cab_desc;
	
	@Column(name = "price", nullable = false)
	private double price;
	
	@Column(name = "pic")
	private String pic;
	
	@Column(name = "cnt_ord")
	private int cnt_ord;

	@Column(name = "odate")
	private Timestamp odate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCab_name() {
		return cab_name;
	}

	public void setCab_name(String cab_name) {
		this.cab_name = cab_name;
	}

	public String getCab_desc() {
		return cab_desc;
	}

	public void setCab_desc(String cab_desc) {
		this.cab_desc = cab_desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getCnt_ord() {
		return cnt_ord;
	}

	public void setCnt_ord(int cnt_ord) {
		this.cnt_ord = cnt_ord;
	}

	public Timestamp getOdate() {
		return odate;
	}

	public void setOdate(Timestamp odate) {
		this.odate = odate;
	}

	public Cabinets(int id, String cab_name, String cab_desc, double price, String pic, int cnt_ord, Timestamp odate) {
		super();
		this.id = id;
		this.cab_name = cab_name;
		this.cab_desc = cab_desc;
		this.price = price;
		this.pic = pic;
		this.cnt_ord = cnt_ord;
		this.odate = odate;
	}

	public Cabinets() {
		super();
	}

	@Override
	public String toString() {
		return "Cabinets [id=" + id + ", cab_name=" + cab_name + ", cab_desc=" + cab_desc + ", price=" + price
				+ ", pic=" + pic + ", cnt_ord=" + cnt_ord + ", odate=" + odate + "]";
	}
	
}
