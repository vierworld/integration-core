package ru.vw.practice.lesson6.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class ProductsInfoResponse {
  private List<Product> products;

  public ProductsInfoResponse() {
  }

  public ProductsInfoResponse(List<Product> products) {
    this.products = products;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  @JsonIgnore
  public boolean isEmpty() {
    return CollectionUtils.isEmpty(products);
  }

}
