package com.example.modularmonolith.customer.internal.service;

import com.example.modularmonolith.customer.internal.model.Customer;
import com.example.modularmonolith.customer.internal.model.mapper.CustomerMapper;
import com.example.modularmonolith.customer.internal.model.request.CustomerRequest;
import com.example.modularmonolith.customer.internal.model.response.CustomerResponse;
import com.example.modularmonolith.customer.internal.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public List<CustomerResponse> getAll() {
        return customerRepository.getAll().stream().map(customerMapper::toResponse).toList();
    }

    public CustomerResponse getById(int id) {
        Optional<Customer> optional = customerRepository.getAll().stream().filter(customer -> customer.getId() == id).findFirst();

        return optional.map(customerMapper::toResponse).orElse(null);
    }

    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        Customer customerDto = customerRepository.add(customerMapper.toDto(customerRequest));

        log.info("Added customer: " + customerDto);

        return customerMapper.toResponse(customerDto);
    }
}
