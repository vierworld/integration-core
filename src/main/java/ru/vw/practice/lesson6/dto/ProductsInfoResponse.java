package ru.vw.practice.lesson6.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class ProductsInfoResponse {
  private List<ProductDto> productDtos;

  public ProductsInfoResponse() {
  }

  public ProductsInfoResponse(List<ProductDto> productDtos) {
    this.productDtos = productDtos;
  }

  public List<ProductDto> getProducts() {
    return productDtos;
  }

  public void setProducts(List<ProductDto> productDtos) {
    this.productDtos = productDtos;
  }

  @JsonIgnore
  public boolean isEmpty() {
    return CollectionUtils.isEmpty(productDtos);
  }

}
