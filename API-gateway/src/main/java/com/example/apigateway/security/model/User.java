package com.example.apigateway.security.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

  private int id;
  private String username;
  private String password;
  private Role role;

}
