package com.abhishek.cetdecoded.config;

import com.abhishek.cetdecoded.utilities.PropertiesFileReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DAOConfig
{
    @Bean
    public DriverManagerDataSource dataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(PropertiesFileReader.getProperty("databaseUrl"));
        dataSource.setUsername(PropertiesFileReader.getProperty("databaseUserName"));
        dataSource.setPassword(PropertiesFileReader.getProperty("databasePassword"));
        return dataSource;
    }
}
