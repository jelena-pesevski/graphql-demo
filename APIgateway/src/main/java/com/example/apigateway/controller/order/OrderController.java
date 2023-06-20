package com.example.apigateway.controller.order;

import com.example.apigateway.model.order.OrderResponse;
import com.example.apigateway.model.order.input.OrderRequest;
import com.example.apigateway.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Controller which resolves GraphQL queries related to orders.
 */

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @QueryMapping
    public List<OrderResponse> orders() {
        return orderService.getAll();
    }

    @QueryMapping
    public List<OrderResponse> ordersByCustomerId(@Argument int customerId) {
        return orderService.getAllByCustomerId(customerId);
    }
    @MutationMapping
    public OrderResponse createOrder(@Argument OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }
}
