package ru.vw.practice.lesson6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vw.practice.lesson.dto.ProductsInfoResponse;
import ru.vw.practice.lesson6.service.ProductIntegrationService;

@RestController
@RequestMapping("api/v2/products")
public class ProductsController {
  private final ProductIntegrationService productIntegrationService;

  public ProductsController(ProductIntegrationService productIntegrationService) {
    this.productIntegrationService = productIntegrationService;
  }

  @GetMapping()
  public ProductsInfoResponse getProductsByUserId(@RequestHeader(value = "userId") long userId) {
    return productIntegrationService.getIntegrationProducts(userId);
  }


}