package com.abhishek.cetdecoded.dao;

import com.abhishek.cetdecoded.mappers.UserMapper;
import com.abhishek.cetdecoded.models.User;
import com.abhishek.cetdecoded.utilities.StoredProcedures;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserDao extends DAO<User>
{
    public List<User> getUserWithEmailId(String emailId) throws SQLException
    {
        return mapToList(executeStoredProc(StoredProcedures.GET_USER.getValue(),
                new HashMap<>()
                {
                    {
                        put("p_email_id", emailId);
                    }
                },
                new UserMapper()
        ));
    }
}
