package com.project.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.configuration.JwtUtil;
import com.project.dto.AuthRequest;
import com.project.entity.User;
import com.project.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired private UserService userService;
    @Autowired private JwtUtil jwtUtil;
    @Autowired private AuthenticationManager authManager;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userService.register(user);
        return ResponseEntity.ok("User Registered Successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody AuthRequest request) {
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        String token = jwtUtil.generateToken(request.getUsername());
        return ResponseEntity.ok(Map.of("jwtToken", token));
    }

}
