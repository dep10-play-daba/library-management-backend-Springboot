package com.example.libraryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

@SpringBootApplication
@EnableConfigurationProperties
public class LibraryAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(LibraryAppApplication.class, args);
	}

}
