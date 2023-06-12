package com.example.modularmonolith.order.controller;

import com.example.modularmonolith.order.internal.OrderService;
import com.example.modularmonolith.order.internal.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/customer/{id}")
    public List<Order> gettAllByCustomerId(@PathVariable int id) {
        return orderService.getAllByCustomerId(id);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }
}
