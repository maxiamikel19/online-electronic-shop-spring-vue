package com.maxi.apionlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.apionlineshop.models.User;
import com.maxi.apionlineshop.services.AuthenticationService;
import com.maxi.apionlineshop.services.UserService;

@RestController
@RequestMapping(value = "/api/authentication")
public class AuthenticationController {
    

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("sign-up")
    public ResponseEntity<?> signUp(@RequestBody User user){
        if(this.userService.findByUsername(user.getUsername()).isPresent()){
            new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(this.userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("sign-in")
    public ResponseEntity<?> singIn(@RequestBody User user){
        return new ResponseEntity<>(this.authenticationService.signIn(user), HttpStatus.OK);
    }
}
