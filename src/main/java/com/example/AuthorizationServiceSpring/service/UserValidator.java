package com.example.AuthorizationServiceSpring.service;

import com.example.AuthorizationServiceSpring.AuthorizationServiceSpringApplication;
import com.example.AuthorizationServiceSpring.exception.InvalidCredentials;
import com.example.AuthorizationServiceSpring.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


public class UserValidator implements HandlerMethodArgumentResolver {

    static final Logger log =
            LoggerFactory.getLogger(AuthorizationServiceSpringApplication.class);

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(MyValidator.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) {


        String user = nativeWebRequest.getParameter("user");

        String password = nativeWebRequest.getParameter("password");

        if (isEmpty(user) || isEmpty(password)) {
            log.info("User name or password is empty");
            throw new InvalidCredentials("User name or password is empty");
        }
        if (user.length() <= 2 || user.length() > 20) {
            log.info("User name or password is empty");
            throw new InvalidCredentials("Incorrect user");
        }
        if (password.length() <= 2 || password.length() > 20) {
            log.info("User name or password is empty");
            throw new InvalidCredentials("Incorrect password");
        }

        return new User(user, password);
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}


