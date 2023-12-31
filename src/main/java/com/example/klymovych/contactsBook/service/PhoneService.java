package com.example.klymovych.contactsBook.service;

import com.example.klymovych.contactsBook.model.Phone;

import java.util.List;

public interface PhoneService {
    Phone create(Phone phone);
    Phone readById(long id);
    Phone update(Phone phone);
    void delete(long id);
    List<Phone> getAll();
}
