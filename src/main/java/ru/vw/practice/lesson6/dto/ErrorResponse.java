package ru.vw.practice.lesson6.dto;

import java.time.OffsetDateTime;

public class ErrorResponse {
  private String errorMessage;
  private String errorCode;
  private OffsetDateTime errorDate;

  public ErrorResponse() {
  }
  public ErrorResponse(String errorMessage, String errorCode, OffsetDateTime errorDate) {
    this.errorMessage = errorMessage;
    this.errorCode = errorCode;
    this.errorDate = errorDate;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public OffsetDateTime getErrorDate() {
    return errorDate;
  }

  public void setErrorDate(OffsetDateTime errorDate) {
    this.errorDate = errorDate;
  }
}
