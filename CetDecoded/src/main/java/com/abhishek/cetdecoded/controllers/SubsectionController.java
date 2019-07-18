package com.abhishek.cetdecoded.controllers;

import com.abhishek.cetdecoded.models.Section;
import com.abhishek.cetdecoded.models.Subsection;
import com.abhishek.cetdecoded.services.SubsectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin("*")
public class SubsectionController
{
    @Autowired
    private SubsectionService subsectionService;

    @GetMapping("sections/{sectionName}/subsections")
    public List<Subsection> getSubsectionsList(@PathVariable("sectionName") String sectionName)
    {
        return subsectionService.getSubsectionsForSection(sectionName);
    }

    private List<String> getSubsectionsListMocked(String sectionName)
    {
        var resultList = new ArrayList<String>();

        switch (sectionName)
        {
            case "Quants":
                resultList.addAll(Arrays.asList(
                        "Time and Work",
                        "Mensuration",
                        "Time, Speed and Distance",
                        "Profit and Loss"
                ));
                break;
            case "LR":
                resultList.addAll(Arrays.asList(
                        "Relations",
                        "Arrangements",
                        "Puzzles",
                        "Reflections"));
                break;
            case "Verbal":
                resultList.addAll(Arrays.asList(
                        "Synonyms",
                        "Antonyms",
                        "Grammar",
                        "Punctuation"));
                break;
        }
        return resultList;
    }
}
