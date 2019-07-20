package com.abhishek.cetdecoded.dto;

import com.abhishek.cetdecoded.models.Question;

import java.util.List;

public class ExerciseInfoDto
{
    private List<ProseQuestionsSet> proseQuestionSets;
    private List<Question> individualQuestions;

    public List<ProseQuestionsSet> getProseQuestionSets()
    {
        return proseQuestionSets;
    }

    public void setProseQuestionSets(List<ProseQuestionsSet> proseQuestionSets)
    {
        this.proseQuestionSets = proseQuestionSets;
    }

    public List<Question> getIndividualQuestions()
    {
        return individualQuestions;
    }

    public void setIndividualQuestions(List<Question> individualQuestions)
    {
        this.individualQuestions = individualQuestions;
    }
}

