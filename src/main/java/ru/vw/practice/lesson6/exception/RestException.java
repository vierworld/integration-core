package ru.vw.practice.lesson6.exception;

import org.springframework.http.HttpStatusCode;

public class RestException extends RuntimeException {
  private final HttpStatusCode httpCode;
  private final String errorCode;
  public String getErrorCode() {
    return errorCode;
  }
  public HttpStatusCode getHttpCode() {
    return httpCode;
  }
  public RestException(String message, String errorCode, HttpStatusCode httpCode) {
    super(message);
    this.errorCode = errorCode;
    this.httpCode = httpCode;
  }
}
