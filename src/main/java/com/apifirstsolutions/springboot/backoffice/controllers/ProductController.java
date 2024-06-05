package com.apifirstsolutions.springboot.backoffice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apifirstsolutions.springboot.backoffice.models.Product;
import com.apifirstsolutions.springboot.backoffice.models.ProductRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("backoffice")
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  @PostMapping("product")
  public String createProduct(@RequestParam String name) {
    Product newProduct = productRepository.save(new Product(name));
    return "New Product saved. Id: " + newProduct.getId() + ", Name: " + newProduct.getName();
  }

  @GetMapping("product")
  public List<Product> getAllProducts() {
    return (List<Product>) productRepository.findAll();
  }

}
