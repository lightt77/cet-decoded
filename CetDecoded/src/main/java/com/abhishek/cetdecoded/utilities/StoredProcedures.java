package com.abhishek.cetdecoded.utilities;

public enum StoredProcedures
{
    GET_ALL_SECTIONS("GET_ALL_SECTIONS"),
    GET_SUBSECTIONS_FOR_SECTION("GET_SUBSECTIONS_FOR_SECTION");

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
