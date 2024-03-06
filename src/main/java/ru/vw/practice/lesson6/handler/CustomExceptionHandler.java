package ru.vw.practice.lesson6.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.vw.practice.lesson6.dto.ErrorResponse;
import ru.vw.practice.lesson6.exception.RestException;

@ControllerAdvice
public class CustomExceptionHandler {
  @ExceptionHandler(RestException.class)
  public ResponseEntity<ErrorResponse> handleCustomException(RestException e) {
    return new ResponseEntity<>(new ErrorResponse(e.getMessage(), e.getErrorCode()), e.getHttpCode());
  }
}