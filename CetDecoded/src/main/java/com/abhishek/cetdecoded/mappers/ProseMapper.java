package com.abhishek.cetdecoded.mappers;

import com.abhishek.cetdecoded.models.Prose;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProseMapper implements RowMapper<Prose>
{
    @Override
    public Prose mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Prose prose = new Prose();
        prose.setId(rs.getInt(1));
        prose.setProseBody(rs.getString(2));
        return prose;
    }
}
