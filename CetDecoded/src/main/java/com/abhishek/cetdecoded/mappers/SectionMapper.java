package com.abhishek.cetdecoded.mappers;

import com.abhishek.cetdecoded.models.Section;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SectionMapper implements RowMapper<Section>
{
    @Override
    public Section mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Section section = new Section();
        section.setSectionName(rs.getString(2));
        return section;
    }
}
