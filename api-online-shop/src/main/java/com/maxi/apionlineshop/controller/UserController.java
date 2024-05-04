package com.maxi.apionlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.apionlineshop.config.UserPrincipal;
import com.maxi.apionlineshop.models.enums.Role;
import com.maxi.apionlineshop.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PutMapping("change/{role}")
    public ResponseEntity<?> changeUserRole(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable Role role){
        this.userService.changeUserRole(role, userPrincipal.getUsername());
        return ResponseEntity.ok(true);
    }
}
