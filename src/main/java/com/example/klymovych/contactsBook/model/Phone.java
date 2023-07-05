package com.example.klymovych.contactsBook.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "phones")
public class Phone extends BaseModel {

    @Pattern(regexp = "^\\+\\d{12}$",
            message = "Must be minimum 12 symbols long and start from +")
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;
}
