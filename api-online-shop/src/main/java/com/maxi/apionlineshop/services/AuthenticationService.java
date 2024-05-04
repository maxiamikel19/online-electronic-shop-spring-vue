package com.maxi.apionlineshop.services;

import com.maxi.apionlineshop.models.User;

public interface AuthenticationService {
    User signIn(User user);
}
