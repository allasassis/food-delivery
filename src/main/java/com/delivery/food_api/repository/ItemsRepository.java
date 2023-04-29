package com.delivery.food_api.repository;

import com.delivery.food_api.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items, Long> {
}
