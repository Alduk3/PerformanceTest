package com.riwi.perfomancetest.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Api para administrar el contenido multimedia", version = "1.0", description = "Documentación api de de administracion de contenido multimedia"))
public class OpenApiConfig {
}
