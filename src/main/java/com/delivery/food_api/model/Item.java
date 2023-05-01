package com.delivery.food_api.model;

import com.delivery.food_api.dto.store.DtoItems;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    private String name;
    private BigDecimal price;

    private String category;

    public Item() {
    }

    public Item(String name, BigDecimal price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Item(DtoItems dtoItem) {
        this.name = dtoItem.name();
        this.price = dtoItem.price();
        this.category = dtoItem.category();
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
