package com.bauzillab.library.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    OpenAPI libraryApiInfo() {
        return new OpenAPI()
                .info(new Info().title("Library API")
                .version("v1")
                .description("API de prática para aprender engenharia REST."));
    }
}
