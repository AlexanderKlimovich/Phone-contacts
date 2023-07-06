package com.example.klymovych.contactsBook.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "roles")
public class Role extends BaseModel {
    @NotBlank(message = "The 'name' cannot be empty")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;
}
