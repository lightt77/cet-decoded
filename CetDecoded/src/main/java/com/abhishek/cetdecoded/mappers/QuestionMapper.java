package com.abhishek.cetdecoded.mappers;

import com.abhishek.cetdecoded.models.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements RowMapper<Question>
{
    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Question question = new Question();
        question.setStatement(rs.getString(2));
        question.setProseId(rs.getInt(3));
        question.setType(rs.getInt(4));
        question.setOptions(rs.getString(5));
        question.setAnswer(rs.getString(6));
        question.setExpectedTimeToAnswer(rs.getInt(9));
        question.setSolution(rs.getString(10));
        return question;
    }
}
