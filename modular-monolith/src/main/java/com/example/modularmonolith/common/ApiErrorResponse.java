package com.example.modularmonolith.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiErrorResponse {

  @Builder.Default
  private LocalDateTime timestamp = LocalDateTime.now();

  private String message;

  private String messageKey;
}
