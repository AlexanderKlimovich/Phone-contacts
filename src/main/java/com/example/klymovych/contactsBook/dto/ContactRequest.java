package com.example.klymovych.contactsBook.dto;

import lombok.Data;

import java.util.List;

@Data
public class ContactRequest {

    private String name;

    private List<String> emails;

    private List<String> phones;
}
