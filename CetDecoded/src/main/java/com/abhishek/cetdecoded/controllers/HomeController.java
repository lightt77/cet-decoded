package com.abhishek.cetdecoded.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class HomeController
{
    @GetMapping
    public List<String> getSections()
    {
        return new ArrayList<>()
        {
            {
                add("LR");
                add("Quants");
                add("Verbal");
            }
        };
    }
}
