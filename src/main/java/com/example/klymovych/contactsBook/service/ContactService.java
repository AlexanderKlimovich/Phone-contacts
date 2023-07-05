package com.example.klymovych.contactsBook.service;

import com.example.klymovych.contactsBook.model.Contact;

import java.util.List;

public interface ContactService {
    Contact create(Contact contact);
    Contact readById(long id);
    Contact update(Contact contact);
    void delete(long id);
    List<Contact> getAll();
}
