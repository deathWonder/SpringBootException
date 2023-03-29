package com.example.AuthorizationServiceSpring.service;

import com.example.AuthorizationServiceSpring.AuthorizationServiceSpringApplication;
import com.example.AuthorizationServiceSpring.exception.InvalidCredentials;
import com.example.AuthorizationServiceSpring.exception.UnauthorizedUser;
import com.example.AuthorizationServiceSpring.repository.Authorities;
import com.example.AuthorizationServiceSpring.repository.User;
import com.example.AuthorizationServiceSpring.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    static final Logger log =
            LoggerFactory.getLogger(AuthorizationServiceSpringApplication.class);

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User visitor) {
        String user = visitor.getUser();
        String password = visitor.getPassword();

        if (isEmpty(user) || isEmpty(password)) {
            log.info("User name or password is empty");
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
