package com.example.apigateway.feign;

import com.example.apigateway.model.order.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "orders-client", url = "${config.main-app.url}")
public interface OrderClient {

    @GetMapping("/orders")
    List<Order> getAll();

    @GetMapping("/orders/customer/{customerId}")
    List<Order> getAllByCustomerId(@PathVariable int customerId);

    @PostMapping("/orders")
    Order createOrder(@RequestBody Order order);
}
