package com.abhishek.cetdecoded.utilities.enums;

public enum QuestionType
{
    INDIVIDUAL(1),
    PROSE(2);

    private int value;
    QuestionType(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
