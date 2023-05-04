package com.delivery.food_api.infra.security;

import com.delivery.food_api.dto.user.DataAuthentication;
import com.delivery.food_api.model.User;
import com.delivery.food_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthCentral {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User cryptography (DataAuthentication dataAuthentication) {
        UserDetails login = userRepository.findByUsername(dataAuthentication.username());

        if (login != null) {
            throw new RuntimeException("This username is registered! Please, choose another one!");
        }

        String password = passwordEncoder.encode(dataAuthentication.password());
        User user = new User(dataAuthentication.username(), password);
        userRepository.save(user);
        return user;
    }
}
