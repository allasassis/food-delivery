package com.delivery.food_api.model;

import com.delivery.food_api.dto.order.DataInsertOrder;
import com.delivery.food_api.dto.order.DtoOrderItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @ElementCollection
    @CollectionTable(name = "order_items",
            joinColumns = @JoinColumn(name = "order_id"))
    @Valid
    private List<OrderItem> list;

    private BigDecimal totalPrice;

    private LocalDateTime dateTime = LocalDateTime.now();
    private Boolean isPaid = false;


    public Order() {
    }

    public Order(Status status, Customer customer, Store store, List<OrderItem> list, BigDecimal totalPrice) {
        this.status = status;
        this.customer = customer;
        this.store = store;
        this.list = list;
        this.totalPrice = totalPrice;
    }

    public Order(DataInsertOrder dto, Customer customer, Store store) {
        this.customer = customer;
        this.store = store;
        this.list = new ArrayList<>();
        for (DtoOrderItem item: dto.list()) {
            this.list.add(new OrderItem(item));
        }
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (OrderItem item: this.list) {
            totalPrice = totalPrice.add(item.getPrice());
        }
        this.totalPrice = totalPrice;
        this.status = Status.PENDING;
    }

    public Status getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Store getStore() {
        return store;
    }

    public List<OrderItem> getList() {
        return list;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Boolean getPaid() {
        return isPaid;
    }
}
