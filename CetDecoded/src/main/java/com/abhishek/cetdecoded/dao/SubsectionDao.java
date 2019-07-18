package com.abhishek.cetdecoded.dao;

import com.abhishek.cetdecoded.mappers.SubsectionMapper;
import com.abhishek.cetdecoded.models.Subsection;
import com.abhishek.cetdecoded.utilities.StoredProcedures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class SubsectionDao extends DAO<Subsection>
{
    @Autowired
    public SubsectionDao(DriverManagerDataSource dataSource)
    {
        super(dataSource);
    }

    public List<Subsection> getSubsectionsForSection(String sectionName)
    {
        List<Subsection> result = new ArrayList<>();
        try
        {
            result = mapToList(executeStoredProc(StoredProcedures.GET_SUBSECTIONS_FOR_SECTION.getValue(),
                    new HashMap<String, String>()
                    {
                        {put("p_section_name", sectionName);}
                    },
                    new SubsectionMapper()
            ));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return result;
    }
}
