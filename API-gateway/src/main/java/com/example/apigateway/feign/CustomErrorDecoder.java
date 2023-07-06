package com.example.apigateway.feign;

import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {

  @Override
  public Exception decode(String s, Response response) {
    String requestUrl = response.request().url();
    Response.Body responseBody = response.body();
    HttpStatus responseStatus = HttpStatus.valueOf(response.status());
    String responseBodyKey = null;

    try {
      responseBodyKey = new String(responseBody.asInputStream().readAllBytes());
      log.info("****************" + responseBodyKey);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return new RestException(responseBodyKey, responseStatus);
  }

}
