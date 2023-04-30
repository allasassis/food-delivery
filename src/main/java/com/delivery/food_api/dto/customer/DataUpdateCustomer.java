package com.delivery.food_api.dto.customer;

import com.delivery.food_api.dto.address.DataUpdateAddress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;

import java.time.LocalDate;

public record DataUpdateCustomer(String name, String lastName, @Email String email, String cellphone,
                                 @Valid DataUpdateAddress address, LocalDate birthDate) {
}
