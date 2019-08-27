package com.abhishek.cetdecoded.dao;

import com.abhishek.cetdecoded.mappers.ExerciseMapper;
import com.abhishek.cetdecoded.mappers.ProseMapper;
import com.abhishek.cetdecoded.mappers.QuestionMapper;
import com.abhishek.cetdecoded.models.Exercise;
import com.abhishek.cetdecoded.models.Prose;
import com.abhishek.cetdecoded.models.Question;
import com.abhishek.cetdecoded.utilities.Constants;
import com.abhishek.cetdecoded.utilities.StoredProcedures;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.*;

@Repository
public class ExerciseDao extends DAO<Exercise>
{
    public ExerciseDao(DriverManagerDataSource driverManagerDataSource)
    {
        super(driverManagerDataSource);
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

    public Map.Entry<ArrayList<Question>, ArrayList<Prose>> getExerciseInfo(String exerciseName, String subsectionName)
    {
        Map<String, String> parameterMap = new HashMap<>()
        {
            { put("p_exercise_name", exerciseName); }
            { put("p_subsection_name", subsectionName); }
        };
        List<Object> storedProcResult = executeStoredProcWithMultipleResultSets(StoredProcedures.GET_EXERCISE_INFO.toString(),
                parameterMap,
                Arrays.asList(Constants.DEFAULT_RESULT_SET_KEY_PREFIX_FOR_STORED_PROCS + "1",
                        Constants.DEFAULT_RESULT_SET_KEY_PREFIX_FOR_STORED_PROCS + "2"),
                Arrays.asList(new QuestionMapper(), new ProseMapper())
        );

        // TODO: fix type cast warning
        // refer https://stackoverflow.com/questions/1570073/java-instanceof-and-generics
        return new AbstractMap.SimpleEntry<>(storedProcResult.get(0) instanceof List? (ArrayList<Question>) storedProcResult.get(0) : new ArrayList<>(),
                storedProcResult.get(1) instanceof List? (ArrayList<Prose>) storedProcResult.get(1) : new ArrayList<>());
    }
}
