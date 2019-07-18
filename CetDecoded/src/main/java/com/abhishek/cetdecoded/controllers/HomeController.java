package com.abhishek.cetdecoded.controllers;

import com.abhishek.cetdecoded.models.Section;
import com.abhishek.cetdecoded.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class HomeController
{
    @Autowired
    private SectionService sectionService;

    @GetMapping("sections")
    public List<Section> getSections()
    {
        return sectionService.getSections();
    }

    private List<Section> getMockedSectionsList()
    {
        return new ArrayList<>()
        {
            {
                add(new Section(){{setSectionName("LR");}});
                add(new Section(){{setSectionName("Quants");}});
                add(new Section(){{setSectionName("Verbal");}});
            }
        };
    }
}
