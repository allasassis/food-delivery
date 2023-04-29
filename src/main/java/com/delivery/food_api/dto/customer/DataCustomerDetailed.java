package com.delivery.food_api.dto.customer;

import com.delivery.food_api.dto.DataAddress;
import com.delivery.food_api.model.Customer;

import java.time.LocalDate;

public record DataCustomerDetailed(String name, String lastName, String email, String cellphone, DataAddress address, LocalDate birthDate, LocalDate creationDate) {

    public DataCustomerDetailed(Customer customer) {
        this(customer.getName(), customer.getLastName(), customer.getEmail(), customer.getCellphone(), new DataAddress(customer.getAddress()), customer.getBirthDate(), customer.getCreationDate());
    }
}
