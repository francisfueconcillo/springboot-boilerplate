package com.apifirstsolutions.store.backoffice.dto;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.format.annotation.NumberFormat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDto {

  @NotBlank(message = "Product Name is required.")
  private String name;
  private String description;

  @DecimalMin(value = "0.00", inclusive = false, message = "Price must be greater than 0")
  private BigDecimal price;
  private List<String> images;

}
