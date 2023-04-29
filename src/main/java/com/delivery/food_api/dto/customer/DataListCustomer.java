package com.delivery.food_api.dto.customer;

import com.delivery.food_api.model.Customer;

public record DataListCustomer(String name, String lastName, String email, String cellphone) {
    public DataListCustomer(Customer customer) {
        this(customer.getName(), customer.getLastName(), customer.getEmail(), customer.getCellphone());
    }
}
