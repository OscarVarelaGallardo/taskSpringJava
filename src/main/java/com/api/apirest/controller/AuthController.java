package com.api.apirest.controller;

import com.api.apirest.dto.RegisterUser;
import com.api.apirest.model.User;
import com.api.apirest.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterUser request){
        return authService.register(request.getEmail(), request.getPassword());
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody RegisterUser request) {
        String token = authService.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(Map.of("token", token));
    }
}
