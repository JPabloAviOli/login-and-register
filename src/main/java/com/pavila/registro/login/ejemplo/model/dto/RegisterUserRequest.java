package com.pavila.registro.login.ejemplo.model.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest implements Serializable {

    @Size(min = 4, max = 50)
    private String name;

    @Size(min = 3, max = 50)
    private String username;

    @Size(min = 8, max = 30)
    private String password;

    @Size(min = 8, max = 30)
    private String repeatedPassword;
}
