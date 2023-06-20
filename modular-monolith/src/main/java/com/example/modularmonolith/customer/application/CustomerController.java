package com.example.modularmonolith.customer.application;

import com.example.modularmonolith.customer.internal.model.request.CustomerRequest;
import com.example.modularmonolith.customer.internal.model.response.CustomerResponse;
import com.example.modularmonolith.customer.internal.service.CustomerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  @GetMapping
  public List<CustomerResponse> getAll() {
    return customerService.getAll();
  }

  @GetMapping("/{id}")
  public CustomerResponse getById(@PathVariable int id) {
    return customerService.getById(id);
  }

  @PostMapping
  public CustomerResponse createCustomer(@RequestBody CustomerRequest customerRequest) {
    return customerService.createCustomer(customerRequest);
  }
}
