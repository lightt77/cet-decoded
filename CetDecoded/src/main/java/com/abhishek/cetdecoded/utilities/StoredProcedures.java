package com.abhishek.cetdecoded.utilities;

public enum StoredProcedures
{
    GET_USER("GET_USER");

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
