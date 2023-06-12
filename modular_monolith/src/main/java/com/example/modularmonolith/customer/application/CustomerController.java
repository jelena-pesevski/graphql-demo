package com.example.modularmonolith.customer.application;

import com.example.modularmonolith.customer.internal.model.request.CustomerRequest;
import com.example.modularmonolith.customer.internal.model.response.CustomerResponse;
import com.example.modularmonolith.customer.internal.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
