package com.delivery.food_api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@JsonIgnoreProperties("list")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> list;

    private BigDecimal totalPrice;

    private LocalDateTime dateTime = LocalDateTime.now();

    public Order() {
    }

    public Order(Status status, Customer customer, Store store, List<OrderItem> list, BigDecimal totalPrice) {
        this.status = status;
        this.customer = customer;
        this.store = store;
        this.list = list;
        this.totalPrice = totalPrice;
    }
}
