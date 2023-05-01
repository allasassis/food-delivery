package com.delivery.food_api.service;

import com.delivery.food_api.dto.store.DataInsertStore;
import com.delivery.food_api.dto.store.DataStoreDetailed;
import com.delivery.food_api.dto.store.DataStoreList;
import com.delivery.food_api.dto.store.DtoItems;
import com.delivery.food_api.model.Item;
import com.delivery.food_api.model.Store;
import com.delivery.food_api.repository.ItemsRepository;
import com.delivery.food_api.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        Optional<Store> store = storeRepository.findById(id);
        if (store.isEmpty()) {
            throw new RuntimeException("This store doesn't exist in our database!");
        }

        return new DataStoreDetailed(store.get());
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


    public void deleteStore(Long id) {
        Optional<Store> store = storeRepository.findById(id);
        if (store.isEmpty()) {
            throw new RuntimeException("This store doesn't exist in our database!");
        }
        itemsRepository.deleteAll(store.get().getMenu());
        storeRepository.deleteById(id);
    }
}
