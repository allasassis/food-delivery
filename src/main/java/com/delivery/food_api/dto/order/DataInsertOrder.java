package com.delivery.food_api.dto.order;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DataInsertOrder(@NotNull @Email String email, @NotNull Long storeId, @NotNull @Valid List<DtoOrderItem> list) {
}
