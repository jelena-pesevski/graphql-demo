package com.example.modularmonolith.customer.internal.repository;

import com.example.modularmonolith.customer.internal.model.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CustomerRepository {

    private static int ID = 3;

    private static final List<Customer> customers = new ArrayList<>(Arrays.asList(Customer.builder().id(1).firstname("John").lastname("Doe").build(),
            Customer.builder().id(2).firstname("Jane").lastname("Austin").build()));


    public List<Customer> getAll() {
        return customers;
    }

    public Customer add(Customer customerDto) {
        customerDto.setId(ID++);
        customers.add(customerDto);

        return customerDto;
    }

}
