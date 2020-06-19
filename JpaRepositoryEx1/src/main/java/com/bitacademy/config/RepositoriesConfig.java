package com.bitacademy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.bitacademy.repositories"})
public class RepositoriesConfig {
    
}