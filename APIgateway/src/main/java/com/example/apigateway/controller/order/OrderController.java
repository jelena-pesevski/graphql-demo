package com.example.apigateway.controller.order;

import com.example.apigateway.model.order.Order;
import com.example.apigateway.model.order.input.CreateOrderInput;
import com.example.apigateway.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @QueryMapping
    public List<Order> orders() {
        return orderService.getAll();
    }

    @QueryMapping
    public List<Order> ordersByCustomerId(@Argument int customerId) {
        return orderService.getAllByCustomerId(customerId);
    }

    @MutationMapping
    public Order createOrder(@Argument CreateOrderInput input) {
        return orderService.createOrder(Order.builder().price(input.price()).customerId(input.customerId()).build());
    }
}
