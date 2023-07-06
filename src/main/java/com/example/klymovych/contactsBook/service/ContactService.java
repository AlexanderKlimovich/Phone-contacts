package com.example.klymovych.contactsBook.service;

import com.example.klymovych.contactsBook.dto.ContactRequest;
import com.example.klymovych.contactsBook.model.Contact;

import java.security.Principal;
import java.util.List;

public interface ContactService {
    Contact create(Contact contact);

    Contact readById(long id);

    Contact update(Contact contact);

    void delete(long id);

    List<Contact> getAll();

    Contact createContactFromContactRequest(ContactRequest contactRequest, Principal principal);

    public List<Contact> getAllByOwner(Principal principal);
}
