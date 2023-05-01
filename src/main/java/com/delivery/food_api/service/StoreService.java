package com.delivery.food_api.service;

import com.delivery.food_api.dto.store.*;
import com.delivery.food_api.model.Customer;
import com.delivery.food_api.model.Item;
import com.delivery.food_api.model.Store;
import com.delivery.food_api.repository.ItemsRepository;
import com.delivery.food_api.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ItemsRepository itemsRepository;

    public List<DataStoreList> listStores() {
        return storeRepository.findAll().stream().map(DataStoreList::new).toList();
    }

    public DataStoreDetailed findById(Long id){
        Store store = verifyIfExists(id);
        return new DataStoreDetailed(store);
    }

    public DataStoreDetailed insertStore(DataInsertStore dto) {
        Store store = new Store(dto);
        storeRepository.save(store);
        List<Item> list = new ArrayList<>();
        if (dto.menu() != null) {
            for (DtoItems item: dto.menu()) {
                Item item1 = new Item(item);
                item1.setStore(store);
                itemsRepository.save(item1);
                list.add(item1);
            }
        }
        return new DataStoreDetailed(store);
    }

    public DataStoreDetailed updateStore(Long storeId, DataUpdateStore dto) {
        Store store = verifyIfExists(storeId);
        store.update(dto);
        storeRepository.save(store);
        return new DataStoreDetailed(store);
    }

    public void deleteStore(Long id) {
        Store store = verifyIfExists(id);
        itemsRepository.deleteAll(store.getMenu());
        storeRepository.deleteById(id);
    }

    private Store verifyIfExists(Long id) {
        Optional<Store> store = storeRepository.findById(id);
        if (store.isEmpty()) {
            throw new RuntimeException("This store doesn't exist!");
        }
        return store.get();
    }
}
