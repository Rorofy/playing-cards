package com.francoiszhao.playing_cards.controller;

import com.francoiszhao.playing_cards.model.User;
import com.francoiszhao.playing_cards.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers(); // Get the list of users
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return 204 No Content if the list is empty
        }
        return ResponseEntity.ok(users); // Return 200 OK with the users list
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUser(@RequestParam Long id) {
        if (id == null || id < 1) {
            return ResponseEntity.badRequest().build(); // Return 400 Bad Request
        }
        Optional<User> user = userService.getUser(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}