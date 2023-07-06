package com.example.apigateway.feign;

import com.example.apigateway.security.model.CustomUserDetails;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;

@Slf4j
public class FeignConfig {

  @Bean
  public RequestInterceptor requestInterceptor() {


    return requestTemplate -> {
      log.info("inside interceptor");
      CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext()
          .getAuthentication().getPrincipal();
      String token = customUserDetails.getJwtToken();
      requestTemplate.header("Authorization", "Bearer " + token);
    };
  }

  @Bean
  public ErrorDecoder errorDecoder() {
    return new CustomErrorDecoder();
  }

}
