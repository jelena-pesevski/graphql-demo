package com.example.apigateway.controller.customer;

import com.example.apigateway.model.customer.Customer;
import com.example.apigateway.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @QueryMapping
    public List<Customer> customers() {
        return customerService.getAll();
    }

}
