package com.example.AuthorizationServiceSpring.exception;

import com.example.AuthorizationServiceSpring.AuthorizationServiceSpringApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler({UnauthorizedUser.class})
    public ResponseEntity<String> UnauthorizedUserHandler(UnauthorizedUser e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.valueOf(401));
    }

    @ExceptionHandler({InvalidCredentials.class})
    public ResponseEntity<String> InvalidCredentialsHandler(InvalidCredentials e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.valueOf(400));
    }

}
