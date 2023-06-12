package com.example.modularmonolith.customer.internal.service;

import com.example.modularmonolith.customer.internal.model.Customer;
import com.example.modularmonolith.customer.internal.model.mapper.CustomerMapper;
import com.example.modularmonolith.customer.internal.model.request.CustomerRequest;
import com.example.modularmonolith.customer.internal.model.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private static int ID = 3;

    private static final List<Customer> customers = new ArrayList<>(Arrays.asList(Customer.builder().id(1).firstname("John").lastname("Doe").build(),
            Customer.builder().id(2).firstname("Jane").lastname("Austin").build()));

    private final CustomerMapper customerMapper;

    public List<CustomerResponse> getAll() {
        return customers.stream().map(customerMapper::toResponse).toList();
    }

    public CustomerResponse getById(int id) {
        Optional<Customer> optional = customers.stream().filter(customer -> customer.getId() == id).findFirst();

        return optional.map(customerMapper::toResponse).orElse(null);
    }

    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        Customer customerDto = customerMapper.toDto(customerRequest);

        customerDto.setId(ID++);
        customers.add(customerDto);
        log.info("Added customer: " + customerDto);

        return customerMapper.toResponse(customerDto);
    }
}
