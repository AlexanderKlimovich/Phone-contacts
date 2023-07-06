package com.example.klymovych.contactsBook.service;

import com.example.klymovych.contactsBook.dto.RegistrationUserDto;
import com.example.klymovych.contactsBook.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User create(RegistrationUserDto user);
    User readById(long id);
    User update(User user);
    void delete(long id);
    List<User> getAll();

    public User findByEmail(String email);

}
