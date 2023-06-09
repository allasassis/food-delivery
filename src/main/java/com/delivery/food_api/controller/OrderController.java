package com.delivery.food_api.controller;

import com.delivery.food_api.dto.order.DataInsertOrder;
import com.delivery.food_api.dto.order.DataOrderDetailed;
import com.delivery.food_api.service.OrderService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@SecurityRequirement(name = "bearer-key")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DataOrderDetailed getOrderById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DataOrderDetailed insertOrder(@RequestBody DataInsertOrder dto) {
        return orderService.insertOrder(dto);
    }

    @PutMapping("/pay/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DataOrderDetailed payOrder(@PathVariable Long id) {
        return orderService.payOrder(id);
    }
}
