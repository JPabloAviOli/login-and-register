package com.pavila.registro.login.ejemplo.service;

import com.pavila.registro.login.ejemplo.exception.InvalidPasswordException;
import com.pavila.registro.login.ejemplo.model.dto.RegisterUserRequest;
import com.pavila.registro.login.ejemplo.model.entity.User;
import com.pavila.registro.login.ejemplo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(RegisterUserRequest request) {
        validatePassword(request);

        User user = User.builder()
                .username(request.getUsername())
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    private void validatePassword(RegisterUserRequest request) {
        if(!StringUtils.hasText(request.getPassword()) || !StringUtils.hasText(request.getRepeatedPassword())){
            throw new InvalidPasswordException("Password don't match");
        }
        if(!request.getPassword().equals(request.getRepeatedPassword())){
            throw new InvalidPasswordException("Password don't match");
        }
    }
}
