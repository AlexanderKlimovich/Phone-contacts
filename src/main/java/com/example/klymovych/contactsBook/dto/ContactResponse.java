package com.example.klymovych.contactsBook.dto;

import com.example.klymovych.contactsBook.model.Contact;
import com.example.klymovych.contactsBook.model.Email;
import com.example.klymovych.contactsBook.model.Phone;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ContactResponse {

    private String name;

    private List<String> emails;

    private List<String> phones;

    public static ContactResponse toContactResponse (Contact contact){
        ContactResponse contactResponse = new ContactResponse();
        contactResponse.setName(contact.getName());
        contactResponse.setEmails(contact.getEmails().stream()
                .map(Email::getName)
                .collect(Collectors.toList()));
        contactResponse.setPhones(contact.getPhones().stream()
                .map(Phone::getPhoneNumber)
                .collect(Collectors.toList()));
        return contactResponse;
    }

}
