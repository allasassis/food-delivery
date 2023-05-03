package com.delivery.food_api.model;

import com.delivery.food_api.dto.order.DtoOrderItem;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Embeddable
public class OrderItem {

    private String name;
    private BigDecimal price;

    public OrderItem() {
    }

    public OrderItem(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public OrderItem(DtoOrderItem item) {
        this.name = item.getName();
        this.price = item.getPrice();
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
