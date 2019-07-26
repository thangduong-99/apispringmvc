package com.congthang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.congthang.entity.Product;
import com.congthang.service.ProductService;


@RestController
public class ProductController {
 
    @Autowired
    private ProductService productService;
    
    @RequestMapping(value = "/product", //
            method = RequestMethod.POST)
    
    public void addEmployee(@RequestBody Product product) {
 
         productService.saveProduct(product);
 
    }
}