package com.delivery.food_api.dto.store;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;
import java.util.List;

public record DataInsertStore(@NotBlank String name, @NotBlank String storeCategory, @NotBlank List<String> closingDays,
                              @NotNull LocalTime openingHours,@NotNull LocalTime closingHours, @Valid List<DtoItems> menu) {
}
