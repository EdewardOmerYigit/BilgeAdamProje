package com.beyazesya.confing;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/v1/**")
                .allowedOrigins("http://localhost:3000","http://localhost:8080")
                .allowedMethods("GET", "POST", "PUT", "DELETE","PATCH")
                .allowedHeaders("Content-Type")
                .allowCredentials(true);
    }

    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.stream()
                .filter(AllEncompassingFormHttpMessageConverter.class::isInstance)
                .map(AllEncompassingFormHttpMessageConverter.class::cast)
                .findFirst()
                .ifPresent(converter -> converter.addSupportedMediaTypes(MediaType.valueOf(MediaType.APPLICATION_FORM_URLENCODED_VALUE)));
    }
}