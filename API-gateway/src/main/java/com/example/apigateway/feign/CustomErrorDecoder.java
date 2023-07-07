package com.example.apigateway.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.io.InputStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
@RequiredArgsConstructor
public class CustomErrorDecoder implements ErrorDecoder {

  private final ObjectMapper objectMapper;

  @Override
  public Exception decode(String s, Response response) {
    Response.Body responseBody = response.body();
    HttpStatus responseStatus = HttpStatus.valueOf(response.status());
    ApiErrorResponse responseObj = null;

    try (InputStream inputStream = responseBody.asInputStream()) {
      responseObj = objectMapper.readValue(inputStream, ApiErrorResponse.class);
      log.info(responseObj.toString());
    } catch (IOException e) {
      log.error("Error parsing feign exception");
    }

    return new RestException(responseObj, responseStatus);
  }

}
