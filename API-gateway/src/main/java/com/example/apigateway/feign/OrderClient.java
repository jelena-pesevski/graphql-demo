package com.example.apigateway.feign;

import com.example.apigateway.model.order.OrderResponse;
import com.example.apigateway.model.order.input.OrderRequest;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * FeignClient for communication with Orders module.
 */
@FeignClient(name = "orders-client", url = "${config.main-app.url}", configuration = FeignConfig.class)
public interface OrderClient {

  @GetMapping("/orders")
  List<OrderResponse> getAll();

  @GetMapping("/orders/customer/{customerId}")
  List<OrderResponse> getAllByCustomerId(@PathVariable int customerId);

  @PostMapping("/orders")
  OrderResponse createOrder(@RequestBody OrderRequest orderRequest);
}
