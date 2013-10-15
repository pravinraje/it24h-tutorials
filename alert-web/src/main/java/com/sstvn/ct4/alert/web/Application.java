package com.sstvn.ct4.alert.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.sstvn.ct4.alert.web.conf.WebMvcConfiguration;

@Import({WebMvcConfiguration.class})
@ComponentScan("com.sstvn.ct4")
@EnableAutoConfiguration
@Configuration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
