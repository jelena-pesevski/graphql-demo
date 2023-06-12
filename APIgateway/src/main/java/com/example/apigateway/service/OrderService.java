package com.example.apigateway.service;

import com.example.apigateway.feign.OrderClient;
import com.example.apigateway.model.customer.Customer;
import com.example.apigateway.model.order.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderClient orderClient;

    public List<Order> getAll() {
        log.info("API Gateway -  sending get all orders request to modulith");
        return orderClient.getAll();
    }

    public List<Order> getAllByCustomerId(int customerId){
        return orderClient.getAllByCustomerId(customerId);
    }

    public Order createOrder(Order order){
        log.info("API Gateway - sending create order request to modulith");
        return orderClient.createOrder(order);
    }
}
