/**
* @author Francisco Ferreira
*/

package com.labseq.labseq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebSecurityConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200/")
                .allowedMethods("GET");
    }
}