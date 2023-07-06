package com.example.klymovych.contactsBook.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "phones")
public class Phone extends BaseModel {

    @Pattern(regexp = "^\\+\\d{12}$",
            message = "Must be minimum 12 symbols long and start from +")
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @ManyToMany(mappedBy = "phones")
    private List<Contact> contacts;
}
