package com.abhishek.cetdecoded.utilities;

public enum StoredProcedures
{
    GET_ALL_SECTIONS("GET_ALL_SECTIONS");

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
