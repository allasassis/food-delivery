package com.delivery.food_api.service;

import com.delivery.food_api.dto.DataInsertCustomer;
import com.delivery.food_api.model.Address;
import com.delivery.food_api.model.Customer;
import com.delivery.food_api.repository.AddressRepository;
import com.delivery.food_api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    public Customer insertCustomer(DataInsertCustomer dto) {
        Customer customer = new Customer(dto);
        Address address = new Address(dto.address());
        addressRepository.save(address);
        customer.setAddress(address);
        customerRepository.save(customer);
        return customer;
    }
}
