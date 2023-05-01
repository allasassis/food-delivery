package com.delivery.food_api.dto.store;

import com.delivery.food_api.model.Item;
import com.delivery.food_api.model.Store;

import java.time.LocalTime;
import java.util.List;

public record DataStoreDetailed(String name, String category, List<String> closingDays, LocalTime openingHours, LocalTime closingHours, List<Item> menu) {
    public DataStoreDetailed(Store store) {
        this(store.getName(), store.getCategory(), store.getClosingDays(), store.getOpeningHours(), store.getClosingHours(), store.getMenu());
    }
}
