package com.congthang.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.congthang.entity.Product;
import com.congthang.mapper.ProductMapper;

@Repository
@Transactional
public class ProductRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void creatProduct(Product product) {
		String sql = "INSERT INTO product (name, price, amount) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, product.getName(), product.getPrice(),product.getAmount());
	}
	public void fixProductById(Product product) {
		String sql = "UPDATE product SET name = ?, price = ? , amount=? WHERE productId = ? ";
		jdbcTemplate.update(sql, product.getName(), product.getPrice(),product.getAmount(),product.getProductId());
	}
	public void deleteProductById(int id) {
		String sql = "DELETE FROM product WHERE productId = " + id;
		jdbcTemplate.update(sql);
	}
	public List<Product> getAll(){
		String sql = "SELECT * FROM product";
		return jdbcTemplate.query(sql, new ProductMapper());
	}
	public Product getProductById(int productId) {
		String sql = "SELECT * FROM product WHERE productId = ?";
		return jdbcTemplate.queryForObject(sql, new ProductMapper(), productId);
	}
}
