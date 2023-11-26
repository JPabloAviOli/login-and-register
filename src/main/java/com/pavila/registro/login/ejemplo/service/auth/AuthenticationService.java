package com.pavila.registro.login.ejemplo.service.auth;


import com.pavila.registro.login.ejemplo.model.dto.RegisterUserRequest;
import com.pavila.registro.login.ejemplo.model.dto.RegisteredUserResponse;
import com.pavila.registro.login.ejemplo.model.dto.auth.AuthenticationRequest;
import com.pavila.registro.login.ejemplo.model.dto.auth.AuthenticationResponse;
import com.pavila.registro.login.ejemplo.model.entity.User;
import com.pavila.registro.login.ejemplo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    @Autowired
    private IUserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public RegisteredUserResponse registerUser(RegisterUserRequest userRequest) {
        User user = userService.registerUser(userRequest);

        String jwt = jwtService.generateToken(user, generateExtraClaims(user));

        return RegisteredUserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .jwt(jwt)
                .build();

    }

    private Map<String, Object> generateExtraClaims(User user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", user.getName());
        extraClaims.put("authorities", user.getAuthorities());

        return extraClaims;
    }

    public AuthenticationResponse login(AuthenticationRequest authRequest) {

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(), authRequest.getPassword()
        );

        authenticationManager.authenticate(authentication);

        User userDetails = userService.findByUsername(authRequest.getUsername()).get();

        String jwt = jwtService.generateToken(userDetails,generateExtraClaims(userDetails));

        return AuthenticationResponse.builder()
                .jwt(jwt)
                .build();
    }
}
