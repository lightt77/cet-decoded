package com.abhishek.cetdecoded.mappers;

import com.abhishek.cetdecoded.models.Exercise;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExerciseMapper implements RowMapper<Exercise>
{
    @Override
    public Exercise mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Exercise exercise = new Exercise();
        exercise.setName(rs.getString(2));
        return exercise;
    }
}
