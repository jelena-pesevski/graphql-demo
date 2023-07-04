package com.example.apigateway.controller.customer;

import com.example.apigateway.model.customer.CustomerResponse;
import com.example.apigateway.service.CustomerService;
import graphql.GraphQLContext;
import java.security.Principal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

/**
 * Controller which resolves GraphQL queries related to customers.
 */
@Controller
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  @QueryMapping
  public List<CustomerResponse> customers(Principal principal, GraphQLContext graphQLContext) {
    System.out.println(principal.getName());
    return customerService.getAll(graphQLContext.get("token"));
  }

  @QueryMapping
  public CustomerResponse customerById(@Argument int id, GraphQLContext graphQLContext) {
    return customerService.getById(id, graphQLContext.get("token"));
  }

}
