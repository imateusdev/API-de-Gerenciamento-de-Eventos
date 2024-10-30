package com.eventos.config;

import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Eventos API")
                        .version("1.0")
                        .description("API para gerenciamento de eventos")
                        .contact(new Contact()
                                .name("Seu Nome")
                                .email("seu@email.com")))
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Development")));
    }
}