package com.delivery.food_api.service;

import com.delivery.food_api.dto.store.DataInsertStore;
import com.delivery.food_api.dto.store.DataStoreDetailed;
import com.delivery.food_api.dto.store.DtoItems;
import com.delivery.food_api.model.Item;
import com.delivery.food_api.model.Store;
import com.delivery.food_api.repository.ItemsRepository;
import com.delivery.food_api.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ItemsRepository itemsRepository;

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
}
