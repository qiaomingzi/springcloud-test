package com.example.springannotation;

import org.springframework.context.annotation.Bean;

public class AppConfig {
    @Bean
    public DemoService myBean() {
       return new DemoService();
     }
}
