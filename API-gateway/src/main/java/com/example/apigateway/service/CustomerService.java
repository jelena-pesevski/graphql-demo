package com.example.apigateway.service;

import com.example.apigateway.feign.CustomerClient;
import com.example.apigateway.model.customer.CustomerResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

  private final CustomerClient customerClient;

  public List<CustomerResponse> getAll() {
    log.info("API Gateway -  sending get all customers request to modulith");

    return customerClient.getAll();
  }

  public CustomerResponse getById(int id) {
    String token = "token";

    log.info("API Gateway -  sending get customer by id request to modulith");

    return customerClient.getById(token, id);
  }

}
