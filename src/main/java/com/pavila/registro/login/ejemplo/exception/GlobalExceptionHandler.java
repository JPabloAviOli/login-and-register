package com.pavila.registro.login.ejemplo.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ProblemDetail handlerUnknownClientesException(ObjectNotFoundException e, HttpServletRequest request) {

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Backend-Message");
        problemDetail.setType(URI.create("error/ObjectNotFoundException"));
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        problemDetail.setProperty("Method", request.getMethod());

        return problemDetail;
    }
    @ExceptionHandler(InvalidPasswordException.class)
    public ProblemDetail handlerInvalidPasswordExceptionException(InvalidPasswordException e, HttpServletRequest request) {

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Backend-Message");
        problemDetail.setType(URI.create("error/InvalidPasswordException"));
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        problemDetail.setProperty("Method", request.getMethod());

        return problemDetail;
    }
}
