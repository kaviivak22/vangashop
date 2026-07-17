package com.rikjo.vaangashop.userservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.rikjo.vaangashop.userservice.dto.UserDTO;
import com.rikjo.vaangashop.userservice.entity.User;
import com.rikjo.vaangashop.userservice.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository repository;

    private UserDTO toDTO(User u) {
        return UserDTO.builder().id(u.getId()).name(u.getName()).email(u.getEmail()).password("********").build();
    }

    public UserDTO registerUser(UserDTO dto) {
        log.info("Registering user matching credentials: {}", dto.getEmail());
        if(repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email target is already taken.");
        }
        User user = User.builder().name(dto.getName()).email(dto.getEmail()).password(dto.getPassword()).build();
        return toDTO(repository.save(user));
    }

    public UserDTO loginUser(String email, String password) {
        log.info("Verifying user execution login: {}", email);
        User user = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid user email parameter matching record."));
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Credential mismatch error.");
        }
        return toDTO(user);
    }

    public UserDTO getUserDetails(Long id) {
        return repository.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("User record index absent."));
    }
}
