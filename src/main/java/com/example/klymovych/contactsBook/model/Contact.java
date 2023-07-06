package com.example.klymovych.contactsBook.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "contacts")
public class Contact extends BaseModel{
    @NotBlank(message = "The 'name' cannot be empty")
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "contact_emails",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "email_id"))
    private List<Email> emails;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "contact_phones",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "phone_id"))
    private List<Phone> phones;
}
