package com.example.apigateway.service;

import com.example.apigateway.feign.OrderClient;
import com.example.apigateway.model.order.OrderResponse;
import com.example.apigateway.model.order.input.OrderRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderClient orderClient;

  public List<OrderResponse> getAll() {
    log.info("API Gateway -  sending get all orders request to modulith");

    return orderClient.getAll();
  }

  public List<OrderResponse> getAllByCustomerId(int customerId) {
    log.info("API Gateway -  sending get orders by customer id request to modulith");

    return orderClient.getAllByCustomerId(customerId);
  }

  public OrderResponse createOrder(OrderRequest orderRequest) {
    log.info("API Gateway - sending create order request to modulith");

    return orderClient.createOrder(orderRequest);
  }
}
