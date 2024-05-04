package com.maxi.apionlineshop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.maxi.apionlineshop.config.UserPrincipal;
import com.maxi.apionlineshop.config.jwt.JwtProvider;
import com.maxi.apionlineshop.models.User;
import com.maxi.apionlineshop.services.AuthenticationService;

@Service
public class AuthenticationServiceIml implements AuthenticationService{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User signIn(User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrincipal);

        User loginUser = userPrincipal.getUser();
        loginUser.setToken(jwt);
        return loginUser;
    }
    
}
