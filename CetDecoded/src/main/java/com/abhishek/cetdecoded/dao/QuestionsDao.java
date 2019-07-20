package com.abhishek.cetdecoded.dao;

import com.abhishek.cetdecoded.mappers.QuestionMapper;
import com.abhishek.cetdecoded.models.Question;
import com.abhishek.cetdecoded.utilities.StoredProcedures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class QuestionsDao extends DAO<Question>
{
    @Autowired
    public QuestionsDao(DriverManagerDataSource dataSource)
    {
        super(dataSource);
    }

    public long getNumberOfExercises(String subsectionName)
    {
        try
        {
            return (long)executeStoredProc(StoredProcedures.GET_NUMBER_OF_EXERCISES.getValue(),
                    new HashMap<>()
                    {
                        {
                            put("p_subsection_name", subsectionName);
                        }
                    });
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Question> getQuestionsOnExercise(int exerciseNumber, String subsectionName)
    {
        List<Question> result = new ArrayList<>();

        try
        {
            result = mapToList(executeStoredProc(StoredProcedures.GET_QUESTIONS_ON_EXERCISE_AND_SECTION.getValue(),
                    new HashMap<>()
                    {
                        {
                            put("p_exercise_number", exerciseNumber);
                            put("p_subsection_name", subsectionName);
                        }
                    },
                    new QuestionMapper()));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return result;
    }
}
