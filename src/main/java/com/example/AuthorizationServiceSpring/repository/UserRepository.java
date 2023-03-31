package com.example.AuthorizationServiceSpring.repository;


import com.example.AuthorizationServiceSpring.exception.UnauthorizedUser;
import com.example.AuthorizationServiceSpring.model.Authorities;
import com.example.AuthorizationServiceSpring.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    public List<Authorities> getUserAuthorities(User visitor) {
       String user = visitor.getUser();
       String password = visitor.getPassword();

        for (User guest: userHasAuthorities
             ) {
            if(guest.getUser().equals(user)){
                if(guest.getPassword().equals(password))
                    return guest.getPrivileges();
                else throw new UnauthorizedUser("User name or password is incorrect");
            }
        }
        return new ArrayList<>();
    }
}
