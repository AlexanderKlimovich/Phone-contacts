package com.example.klymovych.contactsBook.controller;

import com.example.klymovych.contactsBook.dto.ContactRequest;
import com.example.klymovych.contactsBook.dto.ContactResponse;
import com.example.klymovych.contactsBook.model.Contact;
import com.example.klymovych.contactsBook.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/contacts")
public class ContactController {

    private final ContactService contactService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public ResponseEntity<ContactResponse> createContact(@RequestBody ContactRequest contactRequest,
                                                         Principal principal) {

        Contact createdContact = contactService.createContactFromContactRequest(contactRequest, principal);
        contactService.create(createdContact);

        return ResponseEntity.ok(ContactResponse.toContactResponse(createdContact));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        contactService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public ResponseEntity<ContactResponse> updateContact(@PathVariable Long id,
                                                         @RequestBody ContactRequest contactRequest,
                                                         Principal principal) {
        Contact updatingContact = contactService.createContactFromContactRequest(contactRequest, principal);
        updatingContact.setId(id);
        Contact updatedContact = contactService.update(updatingContact);

        return ResponseEntity.ok(ContactResponse.toContactResponse(updatedContact));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public ResponseEntity<List<ContactResponse>> getAllContacts(Principal principal) {
        List<Contact> contacts = contactService.getAllByOwner(principal);

        List<ContactResponse> contactResponses = contacts.stream()
                .map(ContactResponse::toContactResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(contactResponses);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<ContactResponse>> getAllContactsFromApp(Principal principal) {
        List<Contact> contacts = contactService.getAll();

        List<ContactResponse> contactResponses = contacts.stream()
                .map(ContactResponse::toContactResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(contactResponses);
    }

}
