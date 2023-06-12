package com.example.modularmonolith.customer.internal;

import com.example.modularmonolith.customer.internal.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private static final List<Customer> customers = List.of(Customer.builder().id(1).firstname("John").lastname("Doe").build(),
            Customer.builder().id(2).firstname("Jane").lastname("Austin").build());

    public List<Customer> getAll() {
        return customers;
    }

    public Customer getById(int id) {
        return customers.stream().filter(customer -> customer.getId() == id).findAny().orElse(null);
    }
}
