package ru.vw.practice.lesson6.exception;

import org.springframework.http.HttpStatusCode;
import ru.vw.practice.lesson.dto.ValidationFlagsDto;

import java.util.List;

public class RestDetailedException extends RestException {
  private final List<ValidationFlagsDto> validationFlags;
  public List<ValidationFlagsDto> getValidationFlags() {
    return validationFlags;
  }
  public RestDetailedException(String message, String errorCode, HttpStatusCode httpCode, List<ValidationFlagsDto> validationFlags) {
    super(message, errorCode, httpCode);
    this.validationFlags = validationFlags;
  }
}
