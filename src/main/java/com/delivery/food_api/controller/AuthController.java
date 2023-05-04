package com.delivery.food_api.controller;

import com.delivery.food_api.dto.user.DataAuthentication;
import com.delivery.food_api.dto.user.DataJWTtoken;
import com.delivery.food_api.infra.security.AuthCentral;
import com.delivery.food_api.infra.security.TokenService;
import com.delivery.food_api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthCentral authenticationCentral;

    @PostMapping
    @Transactional
    public ResponseEntity<DataJWTtoken> authenticationLogin(@RequestBody DataAuthentication dataAuthentication) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dataAuthentication.username(), dataAuthentication.password());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        String token = tokenService.generateToken((User) authenticate.getPrincipal());

        return ResponseEntity.ok(new DataJWTtoken(token));
    }

    @PostMapping("/new")
    @Transactional
    public ResponseEntity<DataJWTtoken> signUp(@RequestBody DataAuthentication dataAuthentication) {
        User user = authenticationCentral.cryptography(dataAuthentication);
        String token = tokenService.generateToken(user);
        return ResponseEntity.ok(new DataJWTtoken(token));
    }
}
