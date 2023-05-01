package com.delivery.food_api.model;

import com.delivery.food_api.dto.store.DataInsertStore;
import com.delivery.food_api.dto.store.DtoItems;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String storeCategory;

    private List<String> closingDays;

    private LocalTime openingHours;
    private LocalTime closingHours;

    @OneToMany(mappedBy = "store")
    private List<Item> menu;

    public Store() {
    }

    public Store(String name, StoreCategory String, List<String> closingDays, LocalTime openingHours, LocalTime closingHours, List<Item> menu) {
        this.name = name;
        this.storeCategory = storeCategory;
        this.closingDays = closingDays;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
        this.menu = menu;
    }

    public Store(DataInsertStore dto) {
        this.name = dto.name();
        this.storeCategory = dto.storeCategory();
        this.closingDays = dto.closingDays();
        this.openingHours = dto.openingHours();
        this.closingHours = dto.closingHours();
        this.menu = new ArrayList<>();
        for (DtoItems dtoItem: dto.menu()) {
            this.menu.add(new Item(dtoItem));
        }
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return storeCategory;
    }

    public List<String> getClosingDays() {
        return closingDays;
    }

    public LocalTime getOpeningHours() {
        return openingHours;
    }

    public LocalTime getClosingHours() {
        return closingHours;
    }

    public List<Item> getMenu() {
        return menu;
    }
}
