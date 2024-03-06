package ru.vw.practice.lesson6.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.vw.practice.lesson6.dto.PaymentRequest;
import ru.vw.practice.lesson6.dto.Product;
import ru.vw.practice.lesson6.dto.ProductsInfoResponse;

@Service
public class ProductIntegrationService {
  private final RestTemplate productRestTemplate;

  public ProductIntegrationService(RestTemplate productRestTemplate) {
    this.productRestTemplate = productRestTemplate;
  }

  public ProductsInfoResponse getIntegrationProducts(long userId) {
    return productRestTemplate.getForObject("/products/user/%s".formatted(userId), ProductsInfoResponse.class);
  }

  public Product executePayment(PaymentRequest paymentRequest) {
    return productRestTemplate.postForObject("/products/exec", paymentRequest, Product.class);
  }

}
