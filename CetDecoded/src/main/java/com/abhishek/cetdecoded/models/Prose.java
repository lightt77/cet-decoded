package com.abhishek.cetdecoded.models;

public class Prose
{
    private int id;
    private String proseBody;

    public Prose()
    {
    }

    public Prose(String proseBody)
    {
        this.proseBody = proseBody;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getProseBody()
    {
        return proseBody;
    }

    public void setProseBody(String proseBody)
    {
        this.proseBody = proseBody;
    }
}
