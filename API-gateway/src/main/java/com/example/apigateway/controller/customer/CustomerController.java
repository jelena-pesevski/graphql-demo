package com.example.apigateway.controller.customer;

import com.example.apigateway.model.customer.CustomerResponse;
import com.example.apigateway.service.CustomerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

/**
 * Controller which resolves GraphQL queries related to customers.
 */
@Slf4j
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
