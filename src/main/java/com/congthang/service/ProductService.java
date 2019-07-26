package com.congthang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.congthang.entity.Product;
import com.congthang.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public void saveProduct(Product product) {
		productRepository.saveProduct(product);
	}
}
