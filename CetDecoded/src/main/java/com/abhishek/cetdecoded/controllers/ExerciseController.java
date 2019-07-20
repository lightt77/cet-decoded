package com.abhishek.cetdecoded.controllers;

import com.abhishek.cetdecoded.dto.ExerciseInfoDto;
import com.abhishek.cetdecoded.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciseController
{
    @Autowired
    private ExerciseService exerciseService;

    @GetMapping("subsections/{subsectionName}/exercises/{exerciseNumber}")
    public ExerciseInfoDto getExerciseInfo(@PathVariable("subsectionName") String subsectionName,
                                           @PathVariable("exerciseNumber") int exerciseNumber)
    {
        return exerciseService.getInfoForExercise(exerciseNumber, subsectionName);
    }
}
