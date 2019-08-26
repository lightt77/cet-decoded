package com.abhishek.cetdecoded.dao;

import com.abhishek.cetdecoded.utilities.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        simpleJdbcCall.returningResultSet(Constants.DEFAULT_RESULT_SET_KEY_PREFIX_FOR_STORED_PROCS + "1", rowMapper);
        return simpleJdbcCall.execute(parameterMap);
    }

    public Map<String, Object> executeStoredProc(String storedProcName, RowMapper<T> rowMapper) throws SQLException
    {
        SimpleJdbcCall simpleJdbcCall = getJdbcCall(storedProcName);
        simpleJdbcCall.returningResultSet(Constants.DEFAULT_RESULT_SET_KEY_PREFIX_FOR_STORED_PROCS + "1", rowMapper);
        return simpleJdbcCall.execute();
    }

    public List<Object> executeStoredProcWithMultipleResultSets(String storedProcName, Map<String, ?> parameterMap, List<String> resultSetKeys, List<RowMapper> rowMappers)
    {
        SimpleJdbcCall simpleJdbcCall = getJdbcCall(storedProcName);
        IntStream.range(0, rowMappers.size())
                .forEach(index -> simpleJdbcCall.returningResultSet(resultSetKeys.get(index), rowMappers.get(index)));
        Map<String, Object> spResponseMap = simpleJdbcCall.execute(parameterMap);
        return resultSetKeys.stream().map(spResponseMap::get).collect(Collectors.toList());
    }

    public SimpleJdbcCall getJdbcCall(String storedProcName)
    {
        // create new SimpleJdbcCall object for every stored-proc call to avoid metadata-cache clash issues among stored procs
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
        simpleJdbcCall.setProcedureName(storedProcName);
        return simpleJdbcCall;
    }

    public List<T> mapToList(Map<String, Object> resultMap) throws SQLException
    {
        List<T> resultList = new ArrayList<>();
        if (!resultMap.containsKey(Constants.DEFAULT_RESULT_SET_KEY_PREFIX_FOR_STORED_PROCS + "1"))
            throw new SQLException("result key not found");
        // TODO: deal with unsafe type-cast warning
        if(resultMap.get(Constants.DEFAULT_RESULT_SET_KEY_PREFIX_FOR_STORED_PROCS + "1") instanceof List)
            resultList.addAll((List<T>)resultMap.get(Constants.DEFAULT_RESULT_SET_KEY_PREFIX_FOR_STORED_PROCS + "1"));
        return resultList;
    }
}
