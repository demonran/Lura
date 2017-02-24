package com.lura.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 01182799 on 2017/2/24.
 */
@Configuration
public class InitConfig {

    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}
