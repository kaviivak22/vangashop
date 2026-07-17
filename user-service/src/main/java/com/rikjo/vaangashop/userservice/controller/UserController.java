package com.rikjo.vaangashop.userservice.controller;

import com.rikjo.vaangashop.userservice.dto.UserDTO;
import com.rikjo.vaangashop.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserDTO dto) {
        return new ResponseEntity<>(service.registerUser(dto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO dto) {
        return ResponseEntity.ok(service.loginUser(dto.getEmail(), dto.getPassword()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUserDetails(id));
    }
}
