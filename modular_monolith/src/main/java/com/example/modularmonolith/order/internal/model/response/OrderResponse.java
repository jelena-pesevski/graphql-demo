package com.example.modularmonolith.order.internal.model.response;

import lombok.Data;

@Data
public class OrderResponse {

  private int id;
  private double price;
  private int customerId;
}
