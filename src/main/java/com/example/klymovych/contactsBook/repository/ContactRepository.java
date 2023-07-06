package com.example.klymovych.contactsBook.repository;

import com.example.klymovych.contactsBook.model.Contact;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findAllByOwnerId(Long ownerId);
}
