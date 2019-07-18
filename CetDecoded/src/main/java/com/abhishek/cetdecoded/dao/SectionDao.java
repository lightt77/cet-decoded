package com.abhishek.cetdecoded.dao;

import com.abhishek.cetdecoded.mappers.SectionMapper;
import com.abhishek.cetdecoded.models.Section;
import com.abhishek.cetdecoded.utilities.StoredProcedures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SectionDao extends DAO<Section>
{
    @Autowired
    public SectionDao(DriverManagerDataSource dataSource)
    {
        super(dataSource);
    }

    public List<Section> getSections()
    {
        List<Section> result = new ArrayList<>();
        try
        {
            result = mapToList(executeStoredProc(StoredProcedures.GET_ALL_SECTIONS.getValue(), new SectionMapper()));
        }
        catch (SQLException e)
        {
            // TODO: create logger implementation
            e.printStackTrace();
        }
        return result;
    }
}
