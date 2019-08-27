package com.abhishek.cetdecoded.services;

import com.abhishek.cetdecoded.dao.SectionDao;
import com.abhishek.cetdecoded.models.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService
{
    @Autowired
    private SectionDao sectionDao;

    public List<Section> getSections()
    {
        return sectionDao.getSections();
    }
}
