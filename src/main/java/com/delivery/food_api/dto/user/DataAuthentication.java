package com.delivery.food_api.dto.user;

import jakarta.validation.constraints.NotBlank;

public record DataAuthentication(@NotBlank String username, @NotBlank String password) {
}
