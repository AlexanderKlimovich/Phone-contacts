package com.example.klymovych.contactsBook.service;

import com.example.klymovych.contactsBook.dto.RegistrationUserDto;
import com.example.klymovych.contactsBook.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    User create(RegistrationUserDto user);
    User readById(long id);
    User update(User user);
    void delete(long id);
    List<User> getAll();

    Optional<User> findByEmail(String email);

}
