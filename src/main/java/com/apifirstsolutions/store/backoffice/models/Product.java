package com.apifirstsolutions.store.backoffice.models;

import java.math.BigDecimal;
import java.util.List;

import com.apifirstsolutions.store.backoffice.dto.ProductDto;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "images")
  @Nullable
  private List<String> images;

  @Column(name = "price")
  private BigDecimal price;

  public Product() {
    // For persistence
  }

  public Product(ProductDto product) {
    this.name = product.getName();
    this.description = product.getDescription();
    this.images = product.getImages();
    this.price = product.getPrice();
  }

}
