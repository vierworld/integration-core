package ru.vw.practice.lesson6.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.vw.practice.lesson.dto.ErrorDetailedResponse;
import ru.vw.practice.lesson.dto.ErrorResponse;
import ru.vw.practice.lesson6.exception.RestDetailedException;
import ru.vw.practice.lesson6.exception.RestException;

import java.time.OffsetDateTime;

@ControllerAdvice
public class CustomExceptionHandler {
  @ExceptionHandler(RestException.class)
  public ResponseEntity<ErrorResponse> handleCustomException(RestException e) {
    return new ResponseEntity<>(new ErrorResponse(e.getMessage(), e.getErrorCode(), OffsetDateTime.now()), e.getHttpCode());
  }

  @ExceptionHandler(RestDetailedException.class)
  public ResponseEntity<ErrorDetailedResponse> handleCustomException(RestDetailedException e) {
    return new ResponseEntity<>(new ErrorDetailedResponse(e.getMessage(), e.getErrorCode(), OffsetDateTime.now(), e.getValidationFlags()), e.getHttpCode());
  }


}