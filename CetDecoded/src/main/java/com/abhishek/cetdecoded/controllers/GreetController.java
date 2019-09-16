package com.abhishek.cetdecoded.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class GreetController
{
    @GetMapping("greet")
    public String greet(@RequestParam(name = "foo", defaultValue = "World") String name)
    {
        return "Hello " + name;
    }
}
