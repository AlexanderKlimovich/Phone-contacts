package com.example.klymovych.contactsBook.repository;

import com.example.klymovych.contactsBook.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
