package com.example.klymovych.contactsBook.service;

import com.example.klymovych.contactsBook.model.Email;

import java.util.List;

public interface EmailService {
    Email create(Email role);
    Email readById(long id);
    Email update(Email role);
    void delete(long id);
    List<Email> getAll();
}
