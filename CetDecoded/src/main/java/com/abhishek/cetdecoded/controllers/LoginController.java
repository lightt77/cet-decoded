package com.abhishek.cetdecoded.controllers;

import com.abhishek.cetdecoded.dto.LoginDto;
import com.abhishek.cetdecoded.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController("login")
public class LoginController
{
    @Autowired
    private LoginService loginService;

    @PostMapping
    public boolean login(@RequestBody LoginDto body) throws SQLException
    {
        return loginService.validateCredentials(body.getEmailId(), body.getPassword());
    }
}
