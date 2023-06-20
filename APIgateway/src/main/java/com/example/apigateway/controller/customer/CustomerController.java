package com.example.apigateway.controller.customer;

import com.example.apigateway.model.customer.CustomerResponse;
import com.example.apigateway.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Controller which resolves GraphQL queries related to customers.
 */

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @QueryMapping
    public List<CustomerResponse> customers() {
        return customerService.getAll();
    }

    @QueryMapping
    public CustomerResponse customerById(@Argument int id) {
        return customerService.getById(id);
    }

}
