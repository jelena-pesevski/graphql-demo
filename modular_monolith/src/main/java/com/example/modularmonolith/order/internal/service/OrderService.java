package com.example.modularmonolith.order.internal.service;

import com.example.modularmonolith.order.internal.model.Order;
import com.example.modularmonolith.order.internal.model.mapper.OrderMapper;
import com.example.modularmonolith.order.internal.model.request.OrderRequest;
import com.example.modularmonolith.order.internal.model.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private static int ID = 3;
    private static final List<Order> orders = new ArrayList<>(Arrays.asList(Order.builder().id(1).price(1000).customerId(1).build(),
            Order.builder().id(2).price(2000).customerId(2).build()));

    private final OrderMapper orderMapper;

    public List<OrderResponse> getAll() {
        return orders.stream().map(orderMapper::toResponse).toList();
    }

    public List<OrderResponse> getAllByCustomerId(int id) {
        return orders.stream().filter(order -> order.getCustomerId() == id).map(orderMapper::toResponse).toList();
    }

    public OrderResponse createOrder(OrderRequest orderRequest) {
        Order orderDto = orderMapper.toDto(orderRequest);

        orderDto.setId(ID++);
        orders.add(orderDto);
        log.info("Added order:" + orderDto);

        return orderMapper.toResponse(orderDto);
    }
}
