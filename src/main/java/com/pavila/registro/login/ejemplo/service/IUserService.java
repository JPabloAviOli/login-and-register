package com.pavila.registro.login.ejemplo.service;

import com.pavila.registro.login.ejemplo.model.dto.RegisterUserRequest;
import com.pavila.registro.login.ejemplo.model.entity.User;

import java.util.Map;
import java.util.Optional;

public interface IUserService {

    User registerUser(RegisterUserRequest request);


    Optional<User> findByUsername(String username);

}
