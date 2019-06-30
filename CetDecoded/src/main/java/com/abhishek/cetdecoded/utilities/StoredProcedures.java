package com.abhishek.cetdecoded.utilities;

public enum StoredProcedures
{
    GET_USER("GET_USER"),
    ADD_USER("ADD_USER"),
    GET_QUESTIONS_FOR_SECTION("GET_QUESTIONS_FOR_SECTION");

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
