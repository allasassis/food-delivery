package com.delivery.food_api.dto.customer;

import com.delivery.food_api.dto.DataAddress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DataInsertCustomer(@NotBlank String name, @NotBlank String lastName, @NotBlank @Email String email, @NotBlank String cellphone,
                                 @Valid DataAddress address, @NotBlank LocalDate birthDate) {
}
