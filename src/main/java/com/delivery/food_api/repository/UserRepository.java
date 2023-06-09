package com.delivery.food_api.repository;

import com.delivery.food_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
