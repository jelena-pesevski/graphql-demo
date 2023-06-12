package com.example.apigateway.feign;

import com.example.apigateway.model.customer.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer-client", url = "${config.main-app.url}")
public interface CustomerClient {

    @GetMapping("/customers")
    List<Customer> getAll();

    @GetMapping("/customers/{id}")
    Customer getById(@PathVariable int id);

}
