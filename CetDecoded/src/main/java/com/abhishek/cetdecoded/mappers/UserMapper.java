package com.abhishek.cetdecoded.mappers;

import com.abhishek.cetdecoded.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User>
{
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        User user = new User();
        user.setEmailId(rs.getString(2));
        user.setPassword(rs.getString(3));
        user.setRole(rs.getInt(4));
        return user;
    }
}
