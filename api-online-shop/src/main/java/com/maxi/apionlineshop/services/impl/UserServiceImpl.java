package com.maxi.apionlineshop.services.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maxi.apionlineshop.models.User;
import com.maxi.apionlineshop.models.enums.Role;
import com.maxi.apionlineshop.repository.UserRepository;
import com.maxi.apionlineshop.services.UserService;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User saveUser(User user) {
        user.setCreateDate(LocalDate.now());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public void changeUserRole(Role role, String username) {
        this.userRepository.changeTheUserRole(username, role);
    }


}
