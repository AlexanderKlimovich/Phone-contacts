package com.example.klymovych.contactsBook.model;


import javax.persistence.*;
import javax.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "users")
public class User extends BaseModel {

    @Column(name = "username")
    private String username;

    @Pattern(regexp = "[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}", message = "Must be a valid e-mail address")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
                joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
                inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE)
    private List<Contact> contactList;

}
