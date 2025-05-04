package com.example.SmartVision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SmartVisionApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartVisionApplication.class, args);
    }
}

// @Configuration
// class WebConfig implements WebMvcConfigurer {
//     @Override
//     public void addResourceHandlers(ResourceHandlerRegistry registry) {
//         registry
//             .addResourceHandler("/**")
//             .addResourceLocations("classpath:/static/")
//             .resourceChain(false);
//     }
// }