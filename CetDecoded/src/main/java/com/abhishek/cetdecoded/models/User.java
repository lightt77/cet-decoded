package com.abhishek.cetdecoded.models;

public class User
{
    private String emailId;
    private String password;
    private int role;       // TODO: make this an enum

    public User()
    {

    }

    public User(String emailId, String password, int role)
    {
        this.emailId = emailId;
        this.password = password;
        this.role = role;
    }

    public int getRole()
    {
        return role;
    }

    public void setRole(int role)
    {
        this.role = role;
    }

    public String getEmailId()
    {
        return emailId;
    }

    public void setEmailId(String emailId)
    {
        this.emailId = emailId;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
