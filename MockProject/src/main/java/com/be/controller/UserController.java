package com.be.controller;

import com.be.model.User;
import com.be.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // API Edit Profile
    @PutMapping("/{id}")
    public ResponseEntity<Object> editProfile(@PathVariable Long id, @RequestBody User updatedUser) {
        User updated = userService.updateProfile(id, updatedUser);
        if (updated != null) {
            return ResponseEntity.status(201).body(updated);
        } else {
            return ResponseEntity.status(400).body("Invalid input parameters or user not found");
        }
    }
}
