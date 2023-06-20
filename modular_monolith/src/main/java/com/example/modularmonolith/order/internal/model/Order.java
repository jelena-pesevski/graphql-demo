package com.example.modularmonolith.order.internal.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {

  private int id;
  private double price;
  private int customerId;
}
