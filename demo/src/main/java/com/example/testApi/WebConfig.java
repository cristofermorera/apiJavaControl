package com.example.testApi;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // Permitir requisições somente do domínio example.com
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permitir os métodos especificados
                .allowedHeaders("*"); // Permitir todos os cabeçalhos
    }
}
