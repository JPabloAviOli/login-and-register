package com.pavila.registro.login.ejemplo.model.dto.auth;

import lombok.Data;


import java.io.Serializable;

@Data
public class AuthenticationRequest implements Serializable {


   private String username;

   private String password;
}
