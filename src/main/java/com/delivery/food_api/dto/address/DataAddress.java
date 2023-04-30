package com.delivery.food_api.dto.address;

import com.delivery.food_api.model.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataAddress(@NotBlank String street, String complement, @NotNull Integer number, @NotBlank String neighborhood,
                          @NotBlank String city, @NotBlank String state, @NotBlank String country, @NotBlank String zipcode) {

    public DataAddress(Address address) {
        this(address.getStreet(), address.getComplement(), address.getNumber(), address.getNeighborhood(),
                address.getCity(), address.getState(), address.getCountry(), address.getZipcode());
    }
}
