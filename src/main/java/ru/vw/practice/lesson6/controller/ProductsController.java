package ru.vw.practice.lesson6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vw.practice.lesson6.dto.PaymentRequest;
import ru.vw.practice.lesson6.dto.Product;
import ru.vw.practice.lesson6.dto.ProductsInfoResponse;
import ru.vw.practice.lesson6.service.ProductIntegrationService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/products")
public class ProductsController {
  private final ProductIntegrationService productIntegrationService;

  public ProductsController(ProductIntegrationService productIntegrationService) {
    this.productIntegrationService = productIntegrationService;
  }

  @GetMapping("/user/{userId}")
  public ProductsInfoResponse getProductsByUserId(@PathVariable long userId) {
    return productIntegrationService.getIntegrationProducts(userId);
  }

  @GetMapping("/exec")
  public Product execPayment(@RequestParam long productId, @RequestParam BigDecimal amount) {
    return productIntegrationService.executePayment(new PaymentRequest(productId, amount));
  }

}