package com.example.AuthorizationServiceSpring.model;

import jakarta.validation.Valid;

import java.lang.annotation.*;
@Valid
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Documented
public @interface UserInfo {
}


