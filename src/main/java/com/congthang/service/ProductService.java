package com.congthang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.congthang.entity.Product;
import com.congthang.repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public void creatProduct(Product product) {
		productRepository.creatProduct(product);
	}
	public void fixProductById(Product product) {
		productRepository.fixProductById(product);
	}
	public void deleteProductById(int id) {
		productRepository.deleteProductById(id);
	}
	public List<Product> getAll(){
		return productRepository.getAll();
	}
	public Product getProductById(int productId) {
		return productRepository.getProductById(productId);
	}
}
