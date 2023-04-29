package com.delivery.food_api.controller;

import com.delivery.food_api.dto.DataCustomerDetailed;
import com.delivery.food_api.dto.DataInsertCustomer;
import com.delivery.food_api.model.Customer;
import com.delivery.food_api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public DataCustomerDetailed insertCustomer(@RequestBody DataInsertCustomer dto) {
        return customerService.insertCustomer(dto);
    }
}
