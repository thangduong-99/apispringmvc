package com.congthang.entity;

public class Product {
	private int productId;
	private String name;
	private int price;
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
