package com.abhishek.cetdecoded.controllers;

import com.abhishek.cetdecoded.models.Question;
import com.abhishek.cetdecoded.services.QuestionsService;
import com.abhishek.cetdecoded.utilities.collections.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("sections")
@CrossOrigin("*")
public class SectionsController
{
    @Autowired
    private QuestionsService questionsService;

    @GetMapping("getQuestions")
    public List<Question> getQuestionsForSection(String section, int paginationIndex) throws SQLException
    {
        return questionsService.getQuestionsFromSection(section, paginationIndex);
    }

    @GetMapping("getSubsectionsList/{sectionName}")
    public List<String> getSubsectionsList(@PathVariable("sectionName") String sectionName)
    {
        return getSubsectionsListMocked(sectionName);
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
                        "Time, Speed and Work",
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
