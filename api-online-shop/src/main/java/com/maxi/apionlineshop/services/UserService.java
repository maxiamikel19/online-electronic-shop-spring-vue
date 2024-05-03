package com.maxi.apionlineshop.services;

import java.util.Optional;

import com.maxi.apionlineshop.models.User;
import com.maxi.apionlineshop.models.enums.Role;

public interface UserService {
    
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void changeUserRole(Role role, String username);
}
