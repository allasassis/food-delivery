package com.delivery.food_api.controller;

import com.delivery.food_api.dto.customer.DataUpdateCustomer;
import com.delivery.food_api.dto.customer.DataCustomerDetailed;
import com.delivery.food_api.dto.customer.DataInsertCustomer;
import com.delivery.food_api.dto.customer.DataListCustomer;
import com.delivery.food_api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<DataListCustomer>> listCustomers() {
        return ResponseEntity.ok(customerService.listCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataCustomerDetailed> findCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findCustomerById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DataCustomerDetailed> insertCustomer(@RequestBody DataInsertCustomer dto) {
        return ResponseEntity.ok(customerService.insertCustomer(dto));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DataCustomerDetailed> updateCustomer(@PathVariable Long id, @RequestBody DataUpdateCustomer dto) {
        return ResponseEntity.ok(customerService.updateCustomer(id, dto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

}
