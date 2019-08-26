package com.abhishek.cetdecoded.services;

import com.abhishek.cetdecoded.dao.ExerciseDao;
import com.abhishek.cetdecoded.dto.ExerciseInfoDto;
import com.abhishek.cetdecoded.dto.ProseQuestionsSet;
import com.abhishek.cetdecoded.models.Exercise;
import com.abhishek.cetdecoded.models.Prose;
import com.abhishek.cetdecoded.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ExerciseService
{
    @Autowired
    private ExerciseDao exerciseDao;

    public List<String> getExercisesOnSubsection(String subsectionName)
    {
        return exerciseDao.getExercisesOnSubsection(subsectionName)
                .stream()
                .map(Exercise::getName)
                .collect(Collectors.toList());
    }

    public ExerciseInfoDto getExerciseInfo(String exerciseName, String subsectionName)
    {
        Map.Entry<ArrayList<Question>, ArrayList<Prose>> exerciseInfoFromDB = exerciseDao.getExerciseInfo(exerciseName, subsectionName);
        List<Question> questionList = exerciseInfoFromDB.getKey();
        List<Prose> proseList = exerciseInfoFromDB.getValue();

        ExerciseInfoDto exerciseInfoDto = new ExerciseInfoDto();
        exerciseInfoDto.setIndividualQuestions(questionList.stream().filter(question -> question.getType() == 0).collect(Collectors.toList()));
        exerciseInfoDto.setProseQuestionSets(proseList.stream().map(prose ->
            new ProseQuestionsSet(prose, questionList.stream().filter(question -> question.getType() != 0 && question.getProseId() == prose.getId()).collect(Collectors.toList()))
        ).collect(Collectors.toList()));

        return exerciseInfoDto;
    }
}
