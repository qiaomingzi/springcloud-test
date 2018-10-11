package com.example.springannotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DemoService.class)
public class DemoConfig {
}
