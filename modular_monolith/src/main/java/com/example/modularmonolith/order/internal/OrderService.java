package com.example.modularmonolith.order.internal;

import com.example.modularmonolith.order.internal.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class OrderService {

    //    private static final List<Order> orders = List.of(Order.builder().id(1).price(1000).customerId(1).build(),
//            Order.builder().id(2).price(2000).customerId(2).build());

    private static int ID = 3;
    private static final List<Order> orders = new ArrayList<>(Arrays.asList(Order.builder().id(1).price(1000).customerId(1).build(),
            Order.builder().id(2).price(2000).customerId(2).build()));

    public Order createOrder(Order order) {
        order.setId(ID++);
        orders.add(order);

        log.info("Added order: " + order);
        //TODO: publish event so notification is created

        return order;
    }

    public List<Order> getAll() {
        return orders;
    }

    public List<Order> getAllByCustomerId(int id) {
        return orders.stream().filter(order -> order.getCustomerId() == id).toList();
    }
}
