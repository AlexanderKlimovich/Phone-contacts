package com.example.klymovych.contactsBook.service.Impl;

import com.example.klymovych.contactsBook.dto.ContactRequest;
import com.example.klymovych.contactsBook.exception.NullEntityReferenceException;
import com.example.klymovych.contactsBook.model.Contact;
import com.example.klymovych.contactsBook.model.Phone;
import com.example.klymovych.contactsBook.model.User;
import com.example.klymovych.contactsBook.model.Email;
import com.example.klymovych.contactsBook.repository.ContactRepository;
import com.example.klymovych.contactsBook.service.ContactService;
import javax.persistence.EntityNotFoundException;

import com.example.klymovych.contactsBook.service.EmailService;
import com.example.klymovych.contactsBook.service.PhoneService;
import com.example.klymovych.contactsBook.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    private final UserService userService;

    private final EmailService emailService;

    private final PhoneService phoneService;


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

    @Override
    public List<Contact> getAllByOwner(Principal principal) {
        User user = userService.findByEmail(principal.getName()).orElseThrow(() -> new UsernameNotFoundException(
                String.format("User '%s' not found", principal.getName())));
        log.info("Fetching all contacts from one user");
        return contactRepository.findAllByOwnerId(user.getId());
    }

    @Override
    public Contact createContactFromContactRequest(ContactRequest contactRequest, Principal principal){
        log.info("Creating contact from contact request: {}", contactRequest);

        Contact contact = new Contact();
        contact.setName(contactRequest.getName());

        User owner = userService.findByEmail(principal.getName()).orElseThrow(() -> new UsernameNotFoundException(
                String.format("User '%s' not found", principal.getName())));
        contact.setOwner(owner);

        Contact savedContact = contactRepository.save(contact);

        List<Email> emails = contactRequest.getEmails().stream()
                .map(email -> {
                    Email emailObj = new Email();
                    emailObj.setName(email);
                    emailObj.saveContact(savedContact);
                    return emailObj;
                })
                .collect(Collectors.toList());

        List<Phone> phones = contactRequest.getPhones().stream()
                .map(phone -> {
                    Phone phoneObj = new Phone();
                    phoneObj.setPhoneNumber(phone);
                    phoneObj.saveContact(savedContact);
                    return phoneObj;
                })
                .collect(Collectors.toList());

        emails.forEach(emailService::create);
        phones.forEach(phoneService::create);

        savedContact.setEmails(emails);
        savedContact.setPhones(phones);

        Contact updatedContact = update(savedContact);

        log.info("Contact created: {}", updatedContact);

        return updatedContact;

    }
}
