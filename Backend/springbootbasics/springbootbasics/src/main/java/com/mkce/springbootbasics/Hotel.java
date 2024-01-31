package com.mkce.springbootbasics;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel_details")
public class Hotel {

	@Override
	public String toString() {
		return "Student [item_id=" + item_id + ", name=" + name + ", date=" + date + ", price=" + price + "]";
	}
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hotel(Long item_id, String name, String date, int price) {
		super();
		this.item_id = item_id;
		this.name = name;
		this.date = date;
		this.price = price;
	}
	@Id
	private Long item_id;
	public Long getItem_id() {
		return item_id;
	}
	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private String name;
	private String date;
	private int  price;
	
}
