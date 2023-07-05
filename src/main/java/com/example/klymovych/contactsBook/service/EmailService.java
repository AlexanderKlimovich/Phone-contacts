package com.example.klymovych.contactsBook.service;

import com.example.klymovych.contactsBook.model.Email;

import java.util.List;

public interface EmailService {
    Email create(Email email);
    Email readById(long id);
    Email update(Email email);
    void delete(long id);
    List<Email> getAll();
}
