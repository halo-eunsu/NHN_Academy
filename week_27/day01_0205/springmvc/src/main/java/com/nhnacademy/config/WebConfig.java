package com.nhnacademy.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.nhnacademy.**.controller")
public class WebConfig implements WebMvcConfigurer {

    @Override
    public  void configureViewResolvers(ViewResolverRegistry registry){
        registry.jsp(/"WEB-INF/views",".jsp");
    }


    @Override
    public  void addResourcehandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler()
    }


}
