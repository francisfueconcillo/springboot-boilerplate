package com.apifirstsolutions.store.backoffice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apifirstsolutions.store.backoffice.dto.ProductDto;
import com.apifirstsolutions.store.backoffice.models.Product;
import com.apifirstsolutions.store.backoffice.models.ProductRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("backoffice")
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  @PostMapping("product")
  public String createProduct(@Valid @RequestBody ProductDto product) {
    // TODO validate and sanitize "product"
    Product newProduct = productRepository.save(new Product(product));
    return "New Product saved. Id: " + newProduct.getId() + ", Name: " + newProduct.getName();
  }

  @GetMapping("product")
  public List<Product> getAllProducts() {
    return (List<Product>) productRepository.findAll();
  }

  @DeleteMapping("product/{id}")
  public String deleteProduct(@PathVariable Integer id) {
    productRepository.deleteById(id);
    return "Product deleted. Id: " + id.toString();
  }

}
