package com.delivery.food_api.service;

import com.delivery.food_api.dto.order.DataInsertOrder;
import com.delivery.food_api.dto.order.DataOrderDetailed;
import com.delivery.food_api.exception.FoodApiException;
import com.delivery.food_api.model.Customer;
import com.delivery.food_api.model.Order;
import com.delivery.food_api.model.Store;
import com.delivery.food_api.repository.CustomerRepository;
import com.delivery.food_api.repository.OrderRepository;
import com.delivery.food_api.repository.StoreRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private StoreRepository storeRepository;

    public DataOrderDetailed insertOrder(DataInsertOrder dto) {
        Optional<Store> store = storeRepository.findById(dto.storeId());
        Optional<Customer> customer = customerRepository.findByEmail(dto.email());

        if (store.isEmpty() || customer.isEmpty()) {
            throw new FoodApiException("Store or customer doesn't exist.");
        }

        Order order = new Order(dto, customer.get(), store.get());
        orderRepository.save(order);
        return new DataOrderDetailed(order);
    }

    public DataOrderDetailed findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty()) {
            throw new FoodApiException("This order doesn't exist.");
        }
        return new DataOrderDetailed(order.get());
    }

    public DataOrderDetailed payOrder(Long id) {
        Order order = verifier(id);
        order.payOrder();
        return new DataOrderDetailed(order);
    }

    private Order verifier(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty()) {
            throw new FoodApiException("This order doesn't exist.");
        }
        return order.get();
    }
}
