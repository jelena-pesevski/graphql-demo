package com.example.apigateway.feign;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ApiErrorResponse {

  private LocalDateTime timestamp;

  private String message;

  private String messageKey;
}
