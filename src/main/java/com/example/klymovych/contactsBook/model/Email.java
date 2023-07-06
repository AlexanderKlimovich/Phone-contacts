package com.example.klymovych.contactsBook.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "emails")
public class Email extends BaseModel {

    @Pattern(regexp = "[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}", message = "Must be a valid e-mail address")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

}
