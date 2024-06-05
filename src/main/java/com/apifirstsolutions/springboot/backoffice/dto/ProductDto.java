package com.apifirstsolutions.springboot.backoffice.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;

public class ProductDto {

  @Getter
  private String name;

  @Getter
  private String description;

  @Getter
  private BigDecimal price;

  @Getter
  private List<String> images;

}
