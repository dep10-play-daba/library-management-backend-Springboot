package com.example.libraryapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
public class PasswordEncodingConfiguration {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        System.out.println("encoder");
        return new BCryptPasswordEncoder();
    }
}
