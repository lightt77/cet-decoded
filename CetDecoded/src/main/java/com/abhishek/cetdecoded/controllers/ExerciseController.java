package com.abhishek.cetdecoded.controllers;

import com.abhishek.cetdecoded.dto.ExerciseInfoDto;
import com.abhishek.cetdecoded.models.Prose;
import com.abhishek.cetdecoded.models.Question;
import com.abhishek.cetdecoded.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class ExerciseController
{
    @Autowired
    private ExerciseService exerciseService;

    @GetMapping("subsections/{subsectionName}/exercises")
    public List<String> getExercisesOnSubsection(@PathVariable("subsectionName") String subsectionName)
    {
        return exerciseService.getExercisesOnSubsection(subsectionName);
    }

    @GetMapping("subsections/{subsectionName}/exercises/{exerciseName}")
    public ExerciseInfoDto getExerciseInfo(@PathVariable("exerciseName") String exerciseName, @PathVariable("subsectionName") String subsectionName)
    {
        return exerciseService.getExerciseInfo(exerciseName, subsectionName);
    }
}
