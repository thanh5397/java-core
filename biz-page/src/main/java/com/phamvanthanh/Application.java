package com.phamvanthanh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ComponentScan(basePackages={"com.phamvanthanh"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}