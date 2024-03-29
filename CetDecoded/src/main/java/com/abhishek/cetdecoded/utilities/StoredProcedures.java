package com.abhishek.cetdecoded.utilities;

public enum StoredProcedures
{
    GET_ALL_SECTIONS("GET_ALL_SECTIONS"),
    GET_SUBSECTIONS_FOR_SECTION("GET_SUBSECTIONS_FOR_SECTION"),
    GET_EXERCISES_ON_SUBSECTION("GET_EXERCISES_ON_SUBSECTION"),
    GET_EXERCISE_INFO("GET_EXERCISE_INFO");

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
