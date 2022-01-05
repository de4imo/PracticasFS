package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//Video que he seguido para añadir Swagger: https://www.youtube.com/watch?v=ECTRRXJalh0
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors
                                .basePackage("com._SpringBoot_JPA_Hibernate_CRUD"))
                .paths(PathSelectors.any())
                .build();
    }
}
