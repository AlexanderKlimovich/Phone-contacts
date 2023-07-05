package com.example.klymovych.contactsBook.service.Impl;


import com.example.klymovych.contactsBook.exception.NullEntityReferenceException;
import com.example.klymovych.contactsBook.model.Email;
import com.example.klymovych.contactsBook.repository.EmailRepository;
import com.example.klymovych.contactsBook.service.EmailService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;
    @Override
    public Email create(Email email) {
        if (email != null) {
            log.info("Creating email: {}", email);
            return emailRepository.save(email);
        }
        throw new NullEntityReferenceException("Email cannot be 'null'");
    }

    @Override
    public Email readById(long id) {
        log.info("Fetching email by id: {}", id);
        return emailRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Email with id " + id + " not found"));
    }

    @Override
    public Email update(Email email) {
        if (email != null) {
            log.info("Updating email: {}", email);
            readById(email.getId());
            return emailRepository.save(email);
        }
        throw new NullEntityReferenceException("Email cannot be 'null'");
    }

    @Override
    public void delete(long id) {
        log.info("Deleting email by id: {}", id);
        Email email = readById(id);
        emailRepository.delete(email);
    }

    @Override
    public List<Email> getAll() {
        log.info("Fetching all emails");
        return emailRepository.findAll();
    }
}
