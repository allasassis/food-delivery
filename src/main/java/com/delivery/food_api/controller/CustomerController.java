package com.delivery.food_api.controller;

import com.delivery.food_api.dto.customer.DataCustomerDetailed;
import com.delivery.food_api.dto.customer.DataInsertCustomer;
import com.delivery.food_api.dto.customer.DataListCustomer;
import com.delivery.food_api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<DataListCustomer> listCustomers() {
        return customerService.listCustomers();
    }

    @GetMapping("/{id}")
    public DataCustomerDetailed findCustomer(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }

    @PostMapping
    @Transactional
    public DataCustomerDetailed insertCustomer(@RequestBody DataInsertCustomer dto) {
        return customerService.insertCustomer(dto);
    }
}
