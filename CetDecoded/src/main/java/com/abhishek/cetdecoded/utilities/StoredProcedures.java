package com.abhishek.cetdecoded.utilities;

public enum StoredProcedures
{
    GET_ALL_SECTIONS("GET_ALL_SECTIONS"),
    GET_SUBSECTIONS_FOR_SECTION("GET_SUBSECTIONS_FOR_SECTION"),
    GET_QUESTIONS_ON_EXERCISE_AND_SECTION("GET_QUESTIONS_ON_EXERCISE_AND_SECTION"),
    GET_PROSES("GET_PROSES"),
    GET_NUMBER_OF_EXERCISES("GET_NUMBER_OF_EXERCISES");

    private String value;

    StoredProcedures(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
}
