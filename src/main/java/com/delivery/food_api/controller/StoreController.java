package com.delivery.food_api.controller;

import com.delivery.food_api.dto.store.DataInsertStore;
import com.delivery.food_api.dto.store.DataStoreDetailed;
import com.delivery.food_api.dto.store.DataStoreList;
import com.delivery.food_api.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public ResponseEntity<List<DataStoreList>> listStores() {
        return ResponseEntity.ok(storeService.listStores());
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<DataStoreDetailed> findById(@PathVariable Long storeId) {
        return ResponseEntity.ok(storeService.findById(storeId));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DataStoreDetailed> insertStore(@RequestBody DataInsertStore dto) {
        return ResponseEntity.status(201).body(storeService.insertStore(dto));
    }

    @DeleteMapping("/{storeId}")
    @Transactional
    public ResponseEntity deleteStore(@PathVariable Long storeId) {
        storeService.deleteStore(storeId);
        return ResponseEntity.noContent().build();
    }

}
