package com.abhishek.cetdecoded.services;

import com.abhishek.cetdecoded.dao.UserDao;
import com.abhishek.cetdecoded.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class RegistrationService
{
    @Autowired
    UserDao userDao;

    public void registerUser(User user) throws SQLException
    {
        userDao.addUser(user);
    }
}
