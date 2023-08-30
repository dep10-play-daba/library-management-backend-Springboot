package com.example.libraryapp.entity;

import com.example.libraryapp.model.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;
    @NotNull
    String name;
    @NotNull
    String password;
    @NotNull
    @Column(unique = true)
    String contact;
    @NotNull
    String address;
    @NotNull
    @Enumerated(EnumType.STRING)
    Role role;

    public User(String name,String password, String contact, String address, Role role) {
        this.name = name;
        this.password = password;
        this.contact = contact;
        this.address = address;
        this.role = role;
    }
}
