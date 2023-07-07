package com.example.klymovych.contactsBook.controller;

import com.example.klymovych.contactsBook.model.User;
import com.example.klymovych.contactsBook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/users")
//public class UserController {
//
//    private final UserService userService;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<UserResponse> getUserById(@PathVariable long id) {
//        User user = userService.readById(id);
//        UserResponse userResponse = mapToUserResponse(user);
//        return ResponseEntity.ok(userResponse);
//    }
//
//
//    @PutMapping("/{id}")
//    public ResponseEntity<UserResponse> updateUser(@PathVariable long id, @RequestBody UserUpdateRequest userUpdateRequest) {
//        User user = userService.readById(id);
//        // Update user properties with userUpdateRequest data
//        // ...
//
//        User updatedUser = userService.update(user);
//        UserResponse userResponse = mapToUserResponse(updatedUser);
//        return ResponseEntity.ok(userResponse);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
//        userService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<List<UserResponse>> getAllUsers() {
//        List<User> users = userService.getAll();
//        List<UserResponse> userResponses = users.stream()
//                .map(this::mapToUserResponse)
//                .collect(Collectors.toList());
//        return ResponseEntity.ok(userResponses);
//    }
//
//    private UserResponse mapToUserResponse(User user) {
//        UserResponse userResponse = new UserResponse();
//        userResponse.setId(user.getId());
//        userResponse.setUsername(user.getUsername());
//        userResponse.setEmail(user.getEmail());
//        // Set other user properties as needed
//        // ...
//        return userResponse;
//    }
//}
