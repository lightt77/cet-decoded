package com.abhishek.cetdecoded.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DAOConfig
{
    @Value("${databaseUrl}")
    private String databaseUrl;
    @Value("${databaseUserName}")
    private String databaseUserName;
    @Value("${databasePassword}")
    private String databasePassword;
    @Bean
    public DriverManagerDataSource dataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(databaseUserName);
        dataSource.setPassword(databasePassword);
        return dataSource;
    }
}
