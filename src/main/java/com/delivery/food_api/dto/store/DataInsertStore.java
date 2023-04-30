package com.delivery.food_api.dto.store;

import com.delivery.food_api.model.StoreCategory;

import java.time.DayOfWeek;

public record DataInsertStore(String name, StoreCategory category, DayOfWeek closingDays) {
}
