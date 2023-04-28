package com.delivery.food_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataAddress(@NotBlank String street, String complement, @NotNull Integer number, @NotBlank String neighborhood,
                          @NotBlank String city, @NotBlank String state, @NotBlank String country, @NotBlank String zipcode) {
}
