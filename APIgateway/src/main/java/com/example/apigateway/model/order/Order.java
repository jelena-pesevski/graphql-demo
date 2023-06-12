package com.example.apigateway.model.order;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {

    private int id;
    private double price;
    private int customerId;
}
