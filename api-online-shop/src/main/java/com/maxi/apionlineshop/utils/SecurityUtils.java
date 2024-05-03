package com.maxi.apionlineshop.utils;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class SecurityUtils {
    
    private static final String ROLE_PREFIX = "ROLE_";

    public static SimpleGrantedAuthority contertToAuthority(String role){
        String fotmatarRole = role.startsWith(ROLE_PREFIX) ? role : ROLE_PREFIX + role;
        return new SimpleGrantedAuthority(fotmatarRole);
    }
}
