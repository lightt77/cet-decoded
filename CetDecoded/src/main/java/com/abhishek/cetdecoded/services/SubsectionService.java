package com.abhishek.cetdecoded.services;

import com.abhishek.cetdecoded.dao.SubsectionDao;
import com.abhishek.cetdecoded.models.Subsection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubsectionService
{
    @Autowired
    private SubsectionDao subsectionDao;

    public List<Subsection> getSubsectionsForSection(String sectionName)
    {
        return subsectionDao.getSubsectionsForSection(sectionName);
    }
}
