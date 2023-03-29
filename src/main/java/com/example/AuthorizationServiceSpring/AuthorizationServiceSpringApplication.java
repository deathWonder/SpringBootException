package com.example.AuthorizationServiceSpring;

import com.example.AuthorizationServiceSpring.service.UserInfoResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
public class AuthorizationServiceSpringApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServiceSpringApplication.class, args);
    }
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        UserInfoResolver userInfoResolver = new UserInfoResolver();
        argumentResolvers.add(userInfoResolver);
    }
}