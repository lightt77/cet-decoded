package com.abhishek.cetdecoded.dto;
import com.abhishek.cetdecoded.models.Prose;
import com.abhishek.cetdecoded.models.Question;

import java.util.List;

public class ProseQuestionsSet
{
    private Prose prose;
    private List<Question> questionsList;

    public ProseQuestionsSet()
    {
    }

    public ProseQuestionsSet(Prose prose, List<Question> questionsList)
    {
        this.prose = prose;
        this.questionsList = questionsList;
    }

    public Prose getProse()
    {
        return prose;
    }

    public void setProse(Prose prose)
    {
        this.prose = prose;
    }

    public List<Question> getQuestionsList()
    {
        return questionsList;
    }

    public void setQuestionsList(List<Question> questionsList)
    {
        this.questionsList = questionsList;
    }
}
