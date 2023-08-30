package com.example.libraryapp.api;

import com.example.libraryapp.dto.ResponseDTO;
import com.example.libraryapp.dto.UserDTO;
import com.example.libraryapp.session.SessionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthenticationController {
    @Autowired
    public AuthenticationManager manager;
    @Autowired
    public SessionRegistry sessionRegistry;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody UserDTO user) {
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword())
        );

        final String sessionId = sessionRegistry.registerSession(user.getName());
        ResponseDTO response = new ResponseDTO();
        response.setSessionId(sessionId);
        response.setUsername(user.getName());

        return ResponseEntity.ok(response);
    }
}
