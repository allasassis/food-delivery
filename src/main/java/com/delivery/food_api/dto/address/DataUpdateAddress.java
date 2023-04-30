package com.delivery.food_api.dto.address;

public record DataUpdateAddress(String street, String complement, Integer number, String neighborhood,
                                 String city, String state, String country, String zipcode) {
}
