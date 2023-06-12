package com.example.apigateway.feign;

import com.example.apigateway.model.customer.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer-client", url = "${config.main-app.url}")
public interface CustomerClient {

    @GetMapping("/customers")
    List<CustomerResponse> getAll();

    @GetMapping("/customers/{id}")
    CustomerResponse getById(@PathVariable int id);

}
