package com.example.modularmonolith.customer.internal.service;

import com.example.modularmonolith.customer.internal.model.Customer;
import com.example.modularmonolith.customer.internal.model.mapper.CustomerMapper;
import com.example.modularmonolith.customer.internal.model.response.CustomerResponse;
import com.example.modularmonolith.customer.internal.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Spy
    private CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);


    @Test
    void getAll_withExistingCustomers_shouldReturnAList() {
        List<Customer> customers = getListOfCustomers();
        when(customerRepository.getAll()).thenReturn(customers);

        List<CustomerResponse> customerResponses = customerService.getAll();

        assertThat(customerResponses).hasSize(customers.size());

        //just checking mapper, shouldn't be done here
        assertThat(customerResponses.get(0).getFullName()).isEqualTo(String.format("%s %s", customers.get(0).getFirstname(), customers.get(0).getLastname()));
    }

    @Test
    void getAll_withNoCustomers_shouldReturnEmptyList() {
        when(customerRepository.getAll()).thenReturn(List.of());

        List<CustomerResponse> customerResponses = customerService.getAll();

        assertThat(customerResponses).hasSize(0);
    }


    private List<Customer> getListOfCustomers() {
        return new ArrayList<>(Arrays.asList(Customer.builder().id(1).firstname("John").lastname("Doe").build(),
                Customer.builder().id(2).firstname("Jane").lastname("Austin").build()));
    }
}
