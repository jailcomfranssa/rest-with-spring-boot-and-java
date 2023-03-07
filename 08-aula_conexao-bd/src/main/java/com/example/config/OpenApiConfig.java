package com.example.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("RESTfull API with Java 17 and Spring Boot 3")
                        .version("v1")
                        .description("Aprendo REST com curso da Udmy.")
                        .termsOfService("https://github.com/jailcomfranssa")
                        .license(
                                new License()
                                        .name("APACHE 2.0")
                                        .url("https://github.com/jailcomfranssa"))
                );
    }
}
