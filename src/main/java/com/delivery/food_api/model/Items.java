package com.delivery.food_api.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    private String name;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Category category;

    public Items() {
    }

    public Items(String name, BigDecimal price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}
