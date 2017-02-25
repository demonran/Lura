package com.lura.portal.config;


import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by liuran on 2017/2/25.
 */
@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(){

        String projectPath = System.getenv("PROJECT_PATH");

        return DataSourceBuilder.create()
                .url("jdbc:h2:file:"+ projectPath +"/luratest")
                .username("sa")
                .password("sa")
                .driverClassName("org.h2.Driver")
                .build();
    }
}
