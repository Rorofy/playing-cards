package com.francoiszhao.playing_cards.service;

import com.francoiszhao.playing_cards.model.User;
import com.francoiszhao.playing_cards.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean authenticate(String username, String password) {
        // Fetch user by username
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Check if the password matches
            return bCryptPasswordEncoder.matches(password, user.getPassword());
        }
        return false; // User not found or password mismatch
    }
}