package com.delivery.food_api.controller;

import com.delivery.food_api.dto.store.DataStoreDetailed;
import com.delivery.food_api.dto.store.DataInsertStore;
import com.delivery.food_api.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public DataStoreDetailed insertStore(@RequestBody DataInsertStore dto) {
        return null;
    }

}
