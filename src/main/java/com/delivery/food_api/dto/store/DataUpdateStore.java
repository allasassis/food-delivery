package com.delivery.food_api.dto.store;

import java.time.LocalTime;
import java.util.List;

public record DataUpdateStore(String name, String storeCategory, List<String> closingDays, LocalTime openingHours, LocalTime closingHours) {
}
