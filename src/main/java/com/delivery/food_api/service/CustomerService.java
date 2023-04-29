package com.delivery.food_api.service;

import com.delivery.food_api.dto.customer.DataCustomerDetailed;
import com.delivery.food_api.dto.customer.DataInsertCustomer;
import com.delivery.food_api.dto.customer.DataListCustomer;
import com.delivery.food_api.dto.customer.DataUpdateCustomer;
import com.delivery.food_api.model.Address;
import com.delivery.food_api.model.Customer;
import com.delivery.food_api.repository.AddressRepository;
import com.delivery.food_api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    public List<DataListCustomer> listCustomers() {
        return customerRepository.findAll().stream().map(DataListCustomer::new).toList();
    }

    public DataCustomerDetailed findCustomerById(Long id) {
        return new DataCustomerDetailed(verifier(id));
    }

    public DataCustomerDetailed insertCustomer(DataInsertCustomer dto) {
        Customer customer = new Customer(dto);
        Address address = new Address(dto.address());
        addressRepository.save(address);
        customer.setAddress(address);
        customerRepository.save(customer);
        return new DataCustomerDetailed(customer);
    }

    public DataCustomerDetailed updateCustomer(Long id, DataUpdateCustomer dto) {
        Customer customer = verifier(id);
        customer.update(dto);
        customerRepository.save(customer);
        return new DataCustomerDetailed(customer);
    }

    public void deleteCustomer(Long id) {
        verifier(id);
        customerRepository.deleteById(id);
    }

    private Customer verifier(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new RuntimeException("This customer doesn't exist!");
        }
        return customer.get();
    }
}
