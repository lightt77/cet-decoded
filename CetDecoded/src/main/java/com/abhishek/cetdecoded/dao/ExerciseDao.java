package com.abhishek.cetdecoded.dao;

import com.abhishek.cetdecoded.mappers.ExerciseMapper;
import com.abhishek.cetdecoded.models.Exercise;
import com.abhishek.cetdecoded.utilities.StoredProcedures;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ExerciseDao extends DAO<Exercise>
{
    public ExerciseDao(DriverManagerDataSource dataSource)
    {
        super(dataSource);
    }

    public List<Exercise> getExercisesOnSubsection(String subsectionName)
    {
        List<Exercise> result = new ArrayList<>();
        try
        {
           result = mapToList(executeStoredProc(StoredProcedures.GET_EXERCISES_ON_SUBSECTION.toString(),
                    new HashMap<>()
                    {
                        {
                            put("p_subsection_name", subsectionName);
                        }
                    }, new ExerciseMapper()));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
