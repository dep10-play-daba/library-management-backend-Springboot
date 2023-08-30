package com.example.libraryapp.entity;

import com.example.libraryapp.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class MyUserDetails implements UserDetails {
    int userId;
    String userName;
    String password;
    List<GrantedAuthority> authorities;
    public MyUserDetails(String userName,String password){
        this.userName=userName;
        this.password=password;
    }
    public MyUserDetails(User user){
        this.userName=user.getName();
        this.password=user.getPassword();
        this.authorities=Arrays.stream(user.getRole().toString().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MyUserDetails() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println(authorities.get(0));
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
