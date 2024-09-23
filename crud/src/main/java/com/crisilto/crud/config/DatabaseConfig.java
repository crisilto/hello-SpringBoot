package com.crisilto.crud.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

//This annotation tells SpringBoot that must manage this class as a configuration source.
@Configuration
public class DatabaseConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    //This annotation looks for properties in application.properties with the prefix noted and associates it with the DataSource Object.
    //This method creates a DataSource (db connection management) using those properties.
    public DataSource crudDataSource() {
        return DataSourceBuilder.create().build(); //DataSourceBuilder built a DataSource using the configured properties (as URL, user, password... of db).
    }

    @Bean
    //This method creates and returns a JdbcTemplate, which is a Spring tool for executing SQL queries more easily.
    public JdbcTemplate crudJdbcTemplate(DataSource crudDataSource) { //Use the DataSource that is just configured to manage connections to the db.
        var jdbcTemplate = new JdbcTemplate(crudDataSource);
        return jdbcTemplate;
    }

    @Bean
    //This method creates and returns a NamedParameterJdbcTemplate, which is an extension of the JdbcTemplate.
    //NamedParameterJdbcTemplate allows working with named parameters in SQL queries, which improves readability and security.
    //Uses the already created JdbcTemplate (crudJdbcTemplate) as a base.
    public NamedParameterJdbcTemplate crudNamedParameterJdbcTemplate(JdbcTemplate crudJdbcTemplate){
        return new NamedParameterJdbcTemplate(crudJdbcTemplate);
    }
}
