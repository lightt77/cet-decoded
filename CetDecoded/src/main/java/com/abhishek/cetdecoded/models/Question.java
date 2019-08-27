package com.abhishek.cetdecoded.models;

public class Question
{
    private String statement;
    private int proseId;
    private int type;
    private String options;
    private String answer;
    private int expectedTimeToAnswer;
    private String solution;

    public Question()
    {
    }

    public Question(String statement, int proseId, int type, String options, String answer, int expectedTimeToAnswer, String solution)
    {
        this.statement = statement;
        this.proseId = proseId;
        this.type = type;
        this.options = options;
        this.answer = answer;
        this.expectedTimeToAnswer = expectedTimeToAnswer;
        this.solution = solution;
    }

    public String getStatement()
    {
        return statement;
    }

    public void setStatement(String statement)
    {
        this.statement = statement;
    }

    public int getProseId()
    {
        return proseId;
    }

    public void setProseId(int proseId)
    {
        this.proseId = proseId;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public String getOptions()
    {
        return options;
    }

    public void setOptions(String options)
    {
        this.options = options;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    public int getExpectedTimeToAnswer()
    {
        return expectedTimeToAnswer;
    }

    public void setExpectedTimeToAnswer(int expectedTimeToAnswer)
    {
        this.expectedTimeToAnswer = expectedTimeToAnswer;
    }

    public String getSolution()
    {
        return solution;
    }

    public void setSolution(String solution)
    {
        this.solution = solution;
    }
}
