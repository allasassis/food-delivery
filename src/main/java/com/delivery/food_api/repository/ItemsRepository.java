package com.delivery.food_api.repository;

import com.delivery.food_api.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Item, Long> {
}
