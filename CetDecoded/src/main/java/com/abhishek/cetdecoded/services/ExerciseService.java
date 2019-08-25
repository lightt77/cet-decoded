package com.abhishek.cetdecoded.services;

import com.abhishek.cetdecoded.dao.ExerciseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
                .map(exercise -> exercise.getName())
                .collect(Collectors.toList());
    }
}
