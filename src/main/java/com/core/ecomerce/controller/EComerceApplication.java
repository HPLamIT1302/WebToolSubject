package com.core.ecomerce.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan({"com.core.ecomerce"})
@EntityScan("com.core.ecomerce.model")
@EnableJpaRepositories("com.core.ecomerce.dao")
public class EComerceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EComerceApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(EComerceApplication.class, args);
    }

}