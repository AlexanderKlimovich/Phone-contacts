package com.example.klymovych.contactsBook.service;

import com.example.klymovych.contactsBook.model.Contact;

import java.util.List;

public interface ContactService {
    Contact create(Contact role);
    Contact readById(long id);
    Contact update(Contact role);
    void delete(long id);
    List<Contact> getAll();
}
