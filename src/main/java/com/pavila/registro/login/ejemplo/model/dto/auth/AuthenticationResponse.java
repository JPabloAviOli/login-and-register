package com.pavila.registro.login.ejemplo.model.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class AuthenticationResponse {

    private String jwt;
}
