package com.example.apigateway.model.customer;

import lombok.Data;

@Data
public class CustomerResponse {

  private int id;
  private String firstname;
  private String lastname;
  private String fullName;
}
