package com.example.modularmonolith.customer.internal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

    private int id;
    private String firstname;
    private String lastname;
}
