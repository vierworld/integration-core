package ru.vw.practice.lesson6.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vw.practice.lesson.dto.PaymentRequest;
import ru.vw.practice.lesson.dto.ProductDto;
import ru.vw.practice.lesson6.service.ProductIntegrationService;

@RestController
@RequestMapping("api/v2/payment")
public class PaymentController {
  private final ProductIntegrationService productIntegrationService;

  public PaymentController(ProductIntegrationService productIntegrationService) {
    this.productIntegrationService = productIntegrationService;
  }

  @PostMapping("/exec")
  public ProductDto execPayment(@RequestBody PaymentRequest request) {
    return productIntegrationService.executePayment(request);
  }

}
