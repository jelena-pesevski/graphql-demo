package com.example.modularmonolith.customer.internal.model.response;

import lombok.Data;

@Data
public class CustomerResponse {

  private int id;
  private String firstname;
  private String lastname;
  private String fullName;
}
