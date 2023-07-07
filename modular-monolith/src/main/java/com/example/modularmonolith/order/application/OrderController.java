package com.example.modularmonolith.order.application;

import com.example.modularmonolith.common.ApiErrorResponse;
import com.example.modularmonolith.order.internal.model.request.OrderRequest;
import com.example.modularmonolith.order.internal.model.response.OrderResponse;
import com.example.modularmonolith.order.internal.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @GetMapping
  public List<OrderResponse> getAll() {
    return orderService.getAll();
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @GetMapping("/customer/{id}")
  public ResponseEntity<?> getAllByCustomerId(@PathVariable int id) {
    log.info("before throwing exception");
    return new ResponseEntity<>(ApiErrorResponse.builder().messageKey("KLJUC").message("poruka").build(), HttpStatus.NOT_FOUND);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @PostMapping
  public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
    return orderService.createOrder(orderRequest);
  }
}
