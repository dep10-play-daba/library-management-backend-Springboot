package com.example.libraryapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
        @Value("${app.upload.dir:${user.home}}")
        private String uploadDir;
        public String getUploadDir() {
            return uploadDir;
        }
}
