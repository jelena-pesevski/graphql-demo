package com.example.modularmonolith.order.application;

import com.example.modularmonolith.order.internal.model.request.OrderRequest;
import com.example.modularmonolith.order.internal.model.response.OrderResponse;
import com.example.modularmonolith.order.internal.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderResponse> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/customer/{id}")
    public List<OrderResponse> getAllByCustomerId(@PathVariable int id) {
        return orderService.getAllByCustomerId(id);
    }

    @PostMapping
    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }
}
