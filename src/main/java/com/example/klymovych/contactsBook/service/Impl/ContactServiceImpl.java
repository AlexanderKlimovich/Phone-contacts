package com.example.klymovych.contactsBook.service.Impl;

import com.example.klymovych.contactsBook.exception.NullEntityReferenceException;
import com.example.klymovych.contactsBook.model.Contact;
import com.example.klymovych.contactsBook.repository.ContactRepository;
import com.example.klymovych.contactsBook.service.ContactService;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public Contact create(Contact contact) {
        if (contact != null) {
            log.info("Creating contact: {}", contact);
            return contactRepository.save(contact);
        }
        throw new NullEntityReferenceException("Contact cannot be 'null'");
    }

    @Override
    public Contact readById(long id) {
        log.info("Fetching contact by id: {}", id);
        return contactRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Contact with id " + id + " not found"));
    }

    @Override
    public Contact update(Contact contact) {
        if (contact != null) {
            log.info("Updating contact: {}", contact);
            readById(contact.getId());
            return contactRepository.save(contact);
        }
        throw new NullEntityReferenceException("Contact cannot be 'null'");
    }

    @Override
    public void delete(long id) {
        log.info("Deleting contact by id: {}", id);
        Contact contact = readById(id);
        contactRepository.delete(contact);
    }

    @Override
    public List<Contact> getAll() {
        log.info("Fetching all contacts");
        return contactRepository.findAll();
    }
}
