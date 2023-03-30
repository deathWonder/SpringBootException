package com.example.AuthorizationServiceSpring.service;

import com.example.AuthorizationServiceSpring.exception.UnauthorizedUser;
import com.example.AuthorizationServiceSpring.model.Authorities;
import com.example.AuthorizationServiceSpring.model.User;
import com.example.AuthorizationServiceSpring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User visitor) {
        String user = visitor.getUser();

        List<Authorities> userAuthorities = userRepository.getUserAuthorities(visitor);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
