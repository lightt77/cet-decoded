package com.abhishek.cetdecoded.services;

import com.abhishek.cetdecoded.dao.UserDao;
import com.abhishek.cetdecoded.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LoginService
{
    @Autowired
    private UserDao userDao;

    public boolean validateCredentials(String emailId, String password) throws SQLException
    {
        emailId = emailId.trim();
        List<User> userList = userDao.getUserWithEmailId(emailId);
        return userList.size() == 1 && userList.stream().findFirst().filter(user -> user.getPassword().equals(password)).isPresent();
    }
}
