package com.example.AuthorizationServiceSpring.controller;


import com.example.AuthorizationServiceSpring.model.Authorities;
import com.example.AuthorizationServiceSpring.model.User;
import com.example.AuthorizationServiceSpring.service.AuthorizationService;
import com.example.AuthorizationServiceSpring.service.MyValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@MyValidator User user) {
        return service.getAuthorities(user);
    }
}
