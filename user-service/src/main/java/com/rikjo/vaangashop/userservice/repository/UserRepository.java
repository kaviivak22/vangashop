package com.rikjo.vaangashop.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rikjo.vaangashop.userservice.entity.User;

import java.util.Optional;
/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
