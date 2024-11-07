package com.francoiszhao.playing_cards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.francoiszhao.playing_cards.models.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username); // Method to find user by username
}