package com.example.AuthorizationServiceSpring.exception;

public class InvalidCredentials extends RuntimeException {

    public InvalidCredentials(String msg) {
        super(msg);
    }
}
