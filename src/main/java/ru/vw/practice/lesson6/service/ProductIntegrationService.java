package ru.vw.practice.lesson6.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.vw.practice.lesson6.dto.PaymentRequest;
import ru.vw.practice.lesson6.dto.ProductDto;
import ru.vw.practice.lesson6.dto.ProductsInfoResponse;


@Service
public class ProductIntegrationService {
  private final RestTemplate productRestTemplate;

  public ProductIntegrationService(RestTemplate productRestTemplate) {
    this.productRestTemplate = productRestTemplate;
  }

  public ProductsInfoResponse getIntegrationProducts(long userId) {
    HttpHeaders headers = new HttpHeaders();
    headers.set("userId", Long.toString(userId));
    HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
    ResponseEntity<ProductsInfoResponse> response = productRestTemplate.exchange("/api/v1/products", HttpMethod.GET, requestEntity,
            ProductsInfoResponse.class);
    return response.getBody();
  }

  public ProductDto executePayment(PaymentRequest paymentRequest) {
    return productRestTemplate.postForObject("/api/v1/payment/exec", paymentRequest, ProductDto.class);
  }

}
