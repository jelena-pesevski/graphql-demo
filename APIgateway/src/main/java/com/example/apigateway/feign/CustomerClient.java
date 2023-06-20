package com.example.apigateway.feign;

import com.example.apigateway.model.customer.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
 * FeignClient for communication with Customer module.
 */

@FeignClient(name = "customer-client", url = "${config.main-app.url}")
public interface CustomerClient {

    @GetMapping("/customers")
    List<CustomerResponse> getAll();

    @GetMapping("/customers/{id}")
    CustomerResponse getById(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken, @PathVariable int id);

}
