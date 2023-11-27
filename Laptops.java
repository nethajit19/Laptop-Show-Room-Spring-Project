package com.example.LoptopShowRoom.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity 
public class Laptops {
	
	@Id 
	private String model;
	private String brand;
	private Integer price;
	private String processer;
	private Integer ram;
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getProcesser() {
		return processer;
	}
	public void setProcesser(String processer) {
		this.processer = processer;
	}
	public Integer getRam() {
		return ram;
	}
	public void setRam(Integer ram) {
		this.ram = ram;
	}
	
	

}
