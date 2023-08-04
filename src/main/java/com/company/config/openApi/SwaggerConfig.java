package com.company.config.openApi;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class SwaggerConfig {


    String serverLink="http://localhost:8080"; //todo uzgartiraman
 /*   @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*");
            }
        };
    }*/

    @Bean
    public OpenAPI springOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Translation Service")
                        .description("REST API for Translation Service web site")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Jamshid")
                                .email("bahromovjamshid503@gmail.com")
                                .url("https://github.com/JBAKHRAMOV"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://springdoc.org"))
                        .termsOfService("https://swagger.io/terms/"))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"))
                .servers(List.of(
                        new Server().url(serverLink).description("Production Server")
                )).addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components((new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .name("bearerAuth")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT"))
                ));
    }

    @Bean
    public GroupedOpenApi allOpenApi(){
        return GroupedOpenApi.builder()
                .group("all")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public GroupedOpenApi authOpenApi(){
        return GroupedOpenApi.builder()
                .group("auth")
                .pathsToMatch("/api/v1/auth")
                .build();
    }



}
