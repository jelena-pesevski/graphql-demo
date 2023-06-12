package com.example.apigateway.model.order;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderResponse {

    private int id;
    private double price;
    private int customerId;
}
