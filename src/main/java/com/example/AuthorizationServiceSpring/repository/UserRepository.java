package com.example.AuthorizationServiceSpring.repository;


import com.example.AuthorizationServiceSpring.model.Authorities;
import com.example.AuthorizationServiceSpring.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class UserRepository {
    private final CopyOnWriteArrayList<User> userHasAuthorities;

    public UserRepository() {
        this.userHasAuthorities = new CopyOnWriteArrayList<>(new User[]{
                new User("Sabir", "12345", List.of(Authorities.WRITE, Authorities.DELETE)),
                new User("Ribas", "54321", List.of(Authorities.READ))
        });
    }

    public List<Authorities> getUserAuthorities(User user) {
        if (userHasAuthorities.contains(user)) {
            for (User visitor : userHasAuthorities
            ) {
                if (visitor.equals(user))
                    return visitor.getPrivileges();
            }
        }
        return List.of(Authorities.NO_RIGHTS);
    }
}
