package com.abhishek.cetdecoded.models;

public class Exercise
{
    private int id;
    private String name;
    private int parentSubsectionId;

    public Exercise()
    {
    }

    public Exercise(int id, String name, int parentSubsectionId)
    {
        this.id = id;
        this.name = name;
        this.parentSubsectionId = parentSubsectionId;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getParentSubsectionId()
    {
        return parentSubsectionId;
    }

    public void setParentSubsectionId(int parentSubsectionId)
    {
        this.parentSubsectionId = parentSubsectionId;
    }
}
