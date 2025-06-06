package com.api.apirest.service;

import com.api.apirest.model.User;
import com.api.apirest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import io.jsonwebtoken.security.Keys;

import io.jsonwebtoken.Jwts;


import java.util.Date;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User  register (String email, String password){
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(passwordEncoder.encode(password));
        return userRepository.save(newUser);

    }
    private final Key secretKey = Keys.hmacShaKeyFor("clave-secreta-para-jwt-de-256-bits!".getBytes(StandardCharsets.UTF_8));

    public String login(String email, String password) {
        Optional<User> userExist = userRepository.findUserByEmail(email);

        if (userExist.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        }

        User user = userExist.get();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        // Crear token JWT válido por 1 hora
        String token = Jwts.builder()
                .setSubject(user.getEmail())
                .claim("userId", user.getId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hora
                .signWith(secretKey)
                .compact();

        return token;
    }


}
