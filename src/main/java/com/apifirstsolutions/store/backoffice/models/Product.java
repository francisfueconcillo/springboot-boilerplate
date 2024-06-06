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
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @Getter
  private Integer id;

  @Getter
  @Setter
  @Column(name = "name")
  private String name;

  @Getter
  @Setter
  @Column(name = "description")
  private String description;

  @Getter
  @Setter
  @Column(name = "images")
  @Nullable
  private List<String> images;

  @Getter
  @Setter
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
