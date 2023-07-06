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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contact")
    private List<Email> emails;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contact")
    private List<Phone> phones;
}
