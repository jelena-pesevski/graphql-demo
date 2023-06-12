package com.example.apigateway.service;

import com.example.apigateway.feign.CustomerClient;
import com.example.apigateway.model.customer.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerClient customerClient;

    public List<Customer> getAll() {
        log.info("API Gateway -  sending get all customers request to modulith");
        return customerClient.getAll();
    }

}
