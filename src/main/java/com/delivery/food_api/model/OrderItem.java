package com.delivery.food_api.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private String name;
    private BigDecimal price;
    private Boolean isPaid = false;

    public OrderItem() {
    }

    public OrderItem(Order order, String name, BigDecimal price) {
        this.order = order;
        this.name = name;
        this.price = price;
    }
}
