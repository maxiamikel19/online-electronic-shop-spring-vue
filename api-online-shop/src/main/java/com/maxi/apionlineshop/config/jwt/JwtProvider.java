package com.maxi.apionlineshop.config.jwt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

public interface JwtProvider  {
    
    Authentication getAuthentication(HttpServletRequest request);

    boolean isValidToken(HttpServletRequest request);
}
