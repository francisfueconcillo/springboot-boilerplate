package com.apifirstsolutions.springboot.backoffice.models;

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

  public Product() {
    // For persistence
  }

  public Product(String name) {
    this.name = name;
  }

}
