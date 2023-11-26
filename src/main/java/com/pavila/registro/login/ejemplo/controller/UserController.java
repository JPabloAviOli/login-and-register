package com.pavila.registro.login.ejemplo.controller;

import com.pavila.registro.login.ejemplo.model.dto.RegisterUserRequest;
import com.pavila.registro.login.ejemplo.model.dto.RegisteredUserResponse;
import com.pavila.registro.login.ejemplo.service.auth.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("register")
    public ResponseEntity<RegisteredUserResponse> register(@Valid @RequestBody RegisterUserRequest userRequest){
        RegisteredUserResponse registeredUser = authenticationService.registerUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }

}
