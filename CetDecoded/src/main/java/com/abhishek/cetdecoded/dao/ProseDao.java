package com.abhishek.cetdecoded.dao;

import com.abhishek.cetdecoded.mappers.ProseMapper;
import com.abhishek.cetdecoded.models.Prose;
import com.abhishek.cetdecoded.utilities.StoredProcedures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ProseDao extends DAO<Prose>
{
    @Autowired
    public ProseDao(DriverManagerDataSource dataSource)
    {
        super(dataSource);
    }

    public List<Prose> getProsesById(String commaSeperatedProseIds)
    {
        List<Prose> result = new ArrayList<>();

        try
        {
            result = mapToList(executeStoredProc(StoredProcedures.GET_PROSES.getValue(),
                    new HashMap<>()
                    {
                        {
                            put("p_prose_id_set", commaSeperatedProseIds);
                        }
                    },
                    new ProseMapper()));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return result;
    }
}
