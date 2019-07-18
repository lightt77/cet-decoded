package com.abhishek.cetdecoded.mappers;

import com.abhishek.cetdecoded.models.Subsection;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubsectionMapper implements RowMapper<Subsection>
{
    @Override
    public Subsection mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Subsection subsection = new Subsection();
        subsection.setSubsectionName(rs.getString(2));
        return subsection;
    }
}
