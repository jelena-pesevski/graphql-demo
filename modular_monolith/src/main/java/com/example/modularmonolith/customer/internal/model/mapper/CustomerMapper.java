package com.example.modularmonolith.customer.internal.model.mapper;

import com.example.modularmonolith.customer.internal.model.Customer;
import com.example.modularmonolith.customer.internal.model.request.CustomerRequest;
import com.example.modularmonolith.customer.internal.model.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class CustomerMapper {

    public abstract Customer toDto(CustomerRequest customerRequest);

    @Mapping(source = "customer", target = "fullName", qualifiedByName = "generateFullName")
    public abstract CustomerResponse toResponse(Customer customer);

    @Named("generateFullName")
    public String generateFullName(Customer customer) {
        return String.format("%s %s", customer.getFirstname(), customer.getLastname());
    }
}
