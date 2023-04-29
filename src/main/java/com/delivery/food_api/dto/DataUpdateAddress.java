package com.delivery.food_api.dto;

public record DataUpdateAddress(String street, String complement, Integer number, String neighborhood,
                                 String city, String state, String country, String zipcode) {
}
