package ru.vw.practice.lesson6.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;

public class PaymentRequest {
  private Long productId;

  @DecimalMin(value = "0.0", inclusive = false, message = "amount должен быть строго больше нуля")
  @Digits(integer=18, fraction=2, message = "amount должен иметь не больше 18 знаков в целой части и не больше 2-х в дробной части")
  private BigDecimal amount;

  public PaymentRequest() {}

  public PaymentRequest(Long productId, BigDecimal amount) {
    this.productId = productId;
    this.amount = amount;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
}
