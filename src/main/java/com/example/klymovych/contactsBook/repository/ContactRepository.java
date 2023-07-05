package com.example.klymovych.contactsBook.repository;

import com.example.klymovych.contactsBook.model.Contact;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
