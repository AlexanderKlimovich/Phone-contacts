package com.example.klymovych.contactsBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.klymovych.contactsBook.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
