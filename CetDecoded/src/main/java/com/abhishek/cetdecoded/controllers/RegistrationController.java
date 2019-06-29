package com.abhishek.cetdecoded.controllers;

import com.abhishek.cetdecoded.services.RegistrationService;
import com.abhishek.cetdecoded.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("register")
public class RegistrationController
{
    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public void registerUser(@RequestBody User user) throws SQLException
    {
        registrationService.registerUser(user);
    }
}
