package com.example.klymovych.contactsBook.repository;

import com.example.klymovych.contactsBook.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {

    Email findByName(String email);
}
