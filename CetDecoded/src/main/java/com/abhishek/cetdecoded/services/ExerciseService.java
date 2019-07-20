package com.abhishek.cetdecoded.services;

import com.abhishek.cetdecoded.dao.ProseDao;
import com.abhishek.cetdecoded.dao.QuestionsDao;
import com.abhishek.cetdecoded.dto.ExerciseInfoDto;
import com.abhishek.cetdecoded.dto.ProseQuestionsSet;
import com.abhishek.cetdecoded.models.Prose;
import com.abhishek.cetdecoded.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService
{
    @Autowired
    private QuestionsDao questionsDao;
    @Autowired
    private ProseDao proseDao;

    public ExerciseInfoDto getInfoForExercise(int exerciseNumber, String subsectionName)
    {
        List<Question> allQuestions = questionsDao.getQuestionsOnExercise(exerciseNumber, subsectionName);

        StringBuilder commaSeperatedProseIds = new StringBuilder();
        HashMap<Integer, List<Question>> proseIdToQuestionsMap = new HashMap<>();

        allQuestions
                .stream()
                .filter(question -> question.getType() == 2)
                .forEach(question -> {
                    if (!proseIdToQuestionsMap.containsKey(question.getProseId()))
                    {
                        proseIdToQuestionsMap.put(question.getProseId(), new ArrayList<>());
                        commaSeperatedProseIds.append(question.getProseId() + ",");
                    }
                    proseIdToQuestionsMap.get(question.getProseId()).add(question);
                });

        // remove trailing comma if present
        if (commaSeperatedProseIds.length() > 0)
            commaSeperatedProseIds.deleteCharAt(commaSeperatedProseIds.length() - 1);

        List<Prose> allProses = proseDao.getProsesById(commaSeperatedProseIds.toString());

        List<ProseQuestionsSet> proseQuestionsSetsList = new ArrayList<>();
        List<Question> individualQuestions = allQuestions
                                                .stream()
                                                .filter(question -> question.getType() == 1)
                                                .collect(Collectors.toList());

        allProses.forEach(prose -> {
            if (proseIdToQuestionsMap.containsKey(prose.getId()))
            {
                ProseQuestionsSet proseQuestionsSet = new ProseQuestionsSet();
                proseQuestionsSet.setProse(prose);
                proseQuestionsSet.setQuestionsList(proseIdToQuestionsMap.get(prose.getId()));
                proseQuestionsSetsList.add(proseQuestionsSet);
            }
        });

        ExerciseInfoDto response = new ExerciseInfoDto();
        response.setProseQuestionSets(proseQuestionsSetsList);
        response.setIndividualQuestions(individualQuestions);
        return response;
    }
}
