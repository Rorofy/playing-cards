package com.francoiszhao.playing_cards.services;

import com.francoiszhao.playing_cards.models.User;
import com.francoiszhao.playing_cards.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getUsers() {
        // Fetch users directly from the SQL DB
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id) {
        // Fetch a single user by ID from the SQL DB
        return userRepository.findById(id);
    }

    @PostConstruct
    public void createAdminAccount() {
        if(getUsers().isEmpty()) {
            User user = new User();
            user.setUsername("admin");
            user.setEmail("admin@test.com");
            user.setPassword(bCryptPasswordEncoder.encode("admin")); // Reuse the encoder bean
            userRepository.save(user);
        }
    }
}