package com.delivery.food_api.repository;

import com.delivery.food_api.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
