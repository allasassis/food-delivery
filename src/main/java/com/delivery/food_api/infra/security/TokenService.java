package com.delivery.food_api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.delivery.food_api.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("$(api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create().withIssuer("FoodExpress_API").withSubject(user.getUsername()).withExpiresAt(expirationDate()).sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Error generating JWT token: ", exception);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm).withIssuer("FoodExpress_API").build().verify(tokenJWT).getSubject();

        } catch (JWTVerificationException exception){
            throw new RuntimeException("JWT Token invalid or expired!");
        }
    }

    private Instant expirationDate() {
        return LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.of("-03:00"));
    }
}
