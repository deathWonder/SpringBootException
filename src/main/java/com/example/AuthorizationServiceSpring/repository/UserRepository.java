package com.example.AuthorizationServiceSpring.repository;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    ConcurrentHashMap<String, String> userAuthorities = new ConcurrentHashMap<>();

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (userAuthorities.containsKey(user)) {
            if (userAuthorities.get(user).equals(password)) {
                return List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE);
            }
        }
        return new ArrayList<>();
    }
}
