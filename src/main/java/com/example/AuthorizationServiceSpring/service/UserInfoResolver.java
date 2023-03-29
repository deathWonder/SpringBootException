package com.example.AuthorizationServiceSpring.service;

import com.example.AuthorizationServiceSpring.model.User;
import com.example.AuthorizationServiceSpring.model.UserInfo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.HashMap;
import java.util.Map;

public class UserInfoResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(UserInfo.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) {

        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        assert request != null;
        Map<String, String > queries = getQueryMap(request.getQueryString());
        String user = queries.get("user");
        String password = queries.get("password");
        return new User(user, password);
    }
    private Map<String, String> getQueryMap(String query)
    {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<>();
        for (String param : params)
        {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);
        }
        return map;
    }
}


