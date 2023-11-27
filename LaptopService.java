package com.example.LoptopShowRoom.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LaptopService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer servno;
	private String name;
	private String model;
	private Integer price;
	
	
	public Integer getServno() {
		return servno;
	}
	public void setServno(Integer servno) {
		this.servno = servno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	

}
