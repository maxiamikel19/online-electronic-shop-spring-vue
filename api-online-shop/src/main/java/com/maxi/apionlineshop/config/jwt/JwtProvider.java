package com.maxi.apionlineshop.config.jwt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

import com.maxi.apionlineshop.config.UserPrincipal;

public interface JwtProvider  {
    
    String generateToken(UserPrincipal userPrincipal);
    
    Authentication getAuthentication(HttpServletRequest request);

    boolean isValidToken(HttpServletRequest request);
}
