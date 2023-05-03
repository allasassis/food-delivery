package com.delivery.food_api.dto.order;

import java.math.BigDecimal;

public class DtoOrderItem {

    private String name;
    private BigDecimal price;

    public DtoOrderItem() {
    }

    public DtoOrderItem(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
