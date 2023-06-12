package com.example.modularmonolith.order.internal.model.mapper;

import com.example.modularmonolith.order.internal.model.Order;
import com.example.modularmonolith.order.internal.model.request.OrderRequest;
import com.example.modularmonolith.order.internal.model.response.OrderResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toDto(OrderRequest orderRequest);

    OrderResponse toResponse(Order order);

}
