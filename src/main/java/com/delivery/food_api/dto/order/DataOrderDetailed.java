package com.delivery.food_api.dto.order;

import com.delivery.food_api.model.Order;
import com.delivery.food_api.model.OrderItem;
import jakarta.validation.Valid;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record DataOrderDetailed(String email, @Valid List<OrderItem> list, BigDecimal totalPrice, LocalDateTime dateTime, Boolean isPaid) {
    public DataOrderDetailed(Order order) {
        this(order.getCustomer().getEmail(), order.getList(), order.getTotalPrice(), order.getDateTime(), order.getPaid());
    }
}
