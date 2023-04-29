package com.delivery.food_api.model;

import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private StoreCategory category;

    private DayOfWeek closingDays;
    private LocalTime openingHours;
    private LocalTime closingHours;

    @OneToMany(mappedBy = "store")
    private List<Items> menu;

    public Store() {
    }

    public Store(String name, StoreCategory category, DayOfWeek closingDays, LocalTime openingHours, LocalTime closingHours, List<Items> menu) {
        this.name = name;
        this.category = category;
        this.closingDays = closingDays;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public StoreCategory getCategory() {
        return category;
    }

    public DayOfWeek getClosingDays() {
        return closingDays;
    }

    public LocalTime getOpeningHours() {
        return openingHours;
    }

    public LocalTime getClosingHours() {
        return closingHours;
    }

    public List<Items> getMenu() {
        return menu;
    }
}
