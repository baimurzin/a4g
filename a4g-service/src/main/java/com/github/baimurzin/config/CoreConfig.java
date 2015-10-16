package com.github.baimurzin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;

/**
 * Created by vlad on 16.10.15.
 */
@Configuration
@ComponentScan("com.github.baimurzin.service")
public class CoreConfig {
    @Bean
    public Jackson2ObjectMapperFactoryBean jackson2ObjectMapperFactoryBean() {
        Jackson2ObjectMapperFactoryBean factoryBean = new Jackson2ObjectMapperFactoryBean();
        return factoryBean;
    }
}
