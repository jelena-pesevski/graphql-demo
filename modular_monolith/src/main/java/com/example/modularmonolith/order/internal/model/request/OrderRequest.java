package com.example.modularmonolith.order.internal.model.request;

import lombok.Data;

@Data
public class OrderRequest {

    private double price;
    private int customerId;
}
