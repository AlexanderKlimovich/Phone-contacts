package com.example.klymovych.contactsBook.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "phones")
public class Phone extends BaseModel {

    @Pattern(regexp = "^\\+\\d{12}$",
            message = "Must be minimum 12 symbols long and start from +")
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;
}
