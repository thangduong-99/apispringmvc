package com.congthang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue
	@Column(name = "productId", nullable = true)
	private int productId;
	@Column(name = "name", nullable = false , length = 50)
	private String name;
	@Column(name = "price" ,nullable = false)
	private int price;
	@Column(name = "amount" , nullable = false)
	private int amount;
	public Product() {
		super();
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Product(int productId, String name, int price, int amount) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	
}
