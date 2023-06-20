package com.example.modularmonolith.order.application;

import com.example.modularmonolith.order.internal.model.request.OrderRequest;
import com.example.modularmonolith.order.internal.model.response.OrderResponse;
import com.example.modularmonolith.order.internal.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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