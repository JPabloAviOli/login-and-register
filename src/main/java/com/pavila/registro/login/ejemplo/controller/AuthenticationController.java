package com.pavila.registro.login.ejemplo.controller;

import com.pavila.registro.login.ejemplo.model.dto.auth.AuthenticationRequest;
import com.pavila.registro.login.ejemplo.model.dto.auth.AuthenticationResponse;
import com.pavila.registro.login.ejemplo.service.auth.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping("login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody @Valid AuthenticationRequest authenticationRequest){

        AuthenticationResponse authResponse = authenticationService.login(authenticationRequest);
        return ResponseEntity.ok(authResponse);

    }

}
