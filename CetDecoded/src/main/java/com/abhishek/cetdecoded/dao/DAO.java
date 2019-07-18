package com.abhishek.cetdecoded.dao;

import com.abhishek.cetdecoded.utilities.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class DAO<T>
{
    private JdbcTemplate jdbcTemplate;

    public DAO(@Autowired DriverManagerDataSource dataSource)
    {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Map<String, Object> executeStoredProc(String storedProcName, Map<String, ?> parameterMap, RowMapper<T> rowMapper)
    {
        SimpleJdbcCall simpleJdbcCall = getJdbcCall(storedProcName);
        simpleJdbcCall.returningResultSet(Constants.DEFAULT_RESULT_SET_KEY_FOR_STORED_PROCS, rowMapper);
        return simpleJdbcCall.execute(parameterMap);
    }

    public void executeStoredProc(String storedProcName, Map<String, ?> parameterMap) throws SQLException
    {
        SimpleJdbcCall simpleJdbcCall = getJdbcCall(storedProcName);
        simpleJdbcCall.execute(parameterMap);
    }

    public Map<String, Object> executeStoredProc(String storedProcName, RowMapper<T> rowMapper) throws SQLException
    {
        SimpleJdbcCall simpleJdbcCall = getJdbcCall(storedProcName);
        simpleJdbcCall.returningResultSet(Constants.DEFAULT_RESULT_SET_KEY_FOR_STORED_PROCS, rowMapper);
        return simpleJdbcCall.execute();
    }

    private SimpleJdbcCall getJdbcCall(String storedProcName)
    {
        // create new SimpleJdbcCall object for every stored-proc call to avoid metadata-cache clash issues among stored procs
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
        simpleJdbcCall.setProcedureName(storedProcName);
        return simpleJdbcCall;
    }

    public List<T> mapToList(Map<String, Object> resultMap) throws SQLException
    {
        List<T> resultList = new ArrayList<>();
        if(!resultMap.containsKey(Constants.DEFAULT_RESULT_SET_KEY_FOR_STORED_PROCS))
            throw new SQLException("result key not found");
        // TODO: deal with unsafe type-cast warning
        resultList.addAll((List<T>)resultMap.get(Constants.DEFAULT_RESULT_SET_KEY_FOR_STORED_PROCS));
        return resultList;
    }
}
