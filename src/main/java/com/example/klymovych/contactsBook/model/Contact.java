package com.example.klymovych.contactsBook.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

    @OneToMany(mappedBy = "email_id", cascade = CascadeType.REMOVE)
    private List<Email> emails;

    @OneToMany(mappedBy = "phone_id", cascade = CascadeType.REMOVE)
    private List<Phone> phones;
}
