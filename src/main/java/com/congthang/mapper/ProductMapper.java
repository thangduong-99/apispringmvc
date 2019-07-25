package com.congthang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.congthang.entity.Product;



public class ProductMapper implements RowMapper<Product>{
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setProductId(rs.getInt("productId"));
		product.setName(rs.getString("name"));
		product.setPrice(rs.getInt("price"));;
		product.setAmount(rs.getInt("amount"));
		return product;
	}

}
