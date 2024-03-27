package ru.vw.practice.lesson6.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import ru.vw.practice.lesson.dto.ErrorDetailedResponse;
import ru.vw.practice.lesson.dto.ErrorResponse;
import ru.vw.practice.lesson6.exception.RestDetailedException;
import ru.vw.practice.lesson6.exception.RestException;

import java.io.IOException;

@Component
public class RestTemplateErrorHandler implements ResponseErrorHandler {
  private final ObjectMapper objectMapper;

  public RestTemplateErrorHandler(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @Override
  public boolean hasError(ClientHttpResponse response) throws IOException {
    return !response.getStatusCode().is2xxSuccessful();
  }

  @Override
  public void handleError(ClientHttpResponse response) throws IOException {
    if (response.getStatusCode().equals(HttpStatus.UNPROCESSABLE_ENTITY)) {
      ErrorDetailedResponse errorResponse = objectMapper.readValue(response.getBody(), ErrorDetailedResponse.class);
      throw new RestDetailedException("Request error at REST service integration. Root message: %s".formatted(errorResponse.getErrorMessage()),
              errorResponse.getErrorCode(), response.getStatusCode(), errorResponse.getValidationFlags());
    }
    else if (!response.getStatusCode().is2xxSuccessful()) {
      ErrorResponse errorResponse = objectMapper.readValue(response.getBody(), ErrorResponse.class);
      throw new RestException("Error at REST service integration. Root message: %s".formatted(errorResponse.getErrorMessage()),
              errorResponse.getErrorCode(), response.getStatusCode());
    }
  }
}