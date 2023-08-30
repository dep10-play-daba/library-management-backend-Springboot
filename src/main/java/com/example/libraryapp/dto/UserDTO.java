package com.example.libraryapp.dto;

import com.example.libraryapp.model.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

    int userId;
    @NotNull(message = "name can't be Empty")
    @Min(value = 5,message = "name must include at least 5 characters")
    String name;
    @NotNull
    String password;
    @NotNull(message = "contact can't be empty")
    @Pattern(regexp ="^\\d{3}-\\d{7}$" ,message = "not a valid contact")
    String contact;
    @NotNull(message = "address can't be empty")
    @Min(value = 6,message = "address must have at least 6 characters")
    String address;
    @NotNull(message = "Role of the User must be implemented")
    @Enumerated(EnumType.STRING)
    Role role;

    public UserDTO(String name,String password, String contact, String address, Role role) {
        this.name = name;
        this.password=password;
        this.contact = contact;
        this.address = address;
        this.role = role;
    }
}
