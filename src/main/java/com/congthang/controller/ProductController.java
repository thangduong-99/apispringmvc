package com.congthang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
 
    @RequestMapping("/")
    
    public String welcome() {
        return "Hello";
    }
    @RequestMapping(value = "/products", //
            method = RequestMethod.GET)
    
    public List<Product> getAllProduct() {
        List<Product> list = productService.getAll();
        return list;
    }
 
    // URL:
    // http://localhost:8080/SpringMVCRESTful/employee/{empNo}
    // http://localhost:8080/SpringMVCRESTful/employee/{empNo}.xml
    // http://localhost:8080/SpringMVCRESTful/employee/{empNo}.json
    @RequestMapping(value = "/product/{productId}", //
            method = RequestMethod.GET)
    
    public Product getEmployee(@PathVariable("productId") int productId) {
        return productService.getProductById(productId);
    }
 
    // URL:
    // http://localhost:8080/SpringMVCRESTful/employee
    // http://localhost:8080/SpringMVCRESTful/employee.xml
    // http://localhost:8080/SpringMVCRESTful/employee.json
    @RequestMapping(value = "/product", //
            method = RequestMethod.POST)
    
    public void creatProduct(@RequestBody Product product) {
 
         productService.creatProduct(product);;
 
    }
 
    // URL:
    // http://localhost:8080/SpringMVCRESTful/employee
    // http://localhost:8080/SpringMVCRESTful/employee.xml
    // http://localhost:8080/SpringMVCRESTful/employee.json
//    @RequestMapping(value = "/employee", //
//            method = RequestMethod.PUT)
//    
//    public Employee updateEmployee(@RequestBody Employee emp) {
// 
//        return employeeDAO.updateEmployee(emp);
//    }
 
    // URL:
    // http://localhost:8080/SpringMVCRESTful/employee/{empNo}
    @RequestMapping(value = "/product/{productId}", //
            method = RequestMethod.DELETE)
    
    public void deleteEmployee(@PathVariable("productId") int productId) {
        productService.deleteProductById(productId);;
    }
 
}