package com.codedbyjst.movingRobot.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("프로보노 프로젝트 API")
                .version("2023.07.01ver")
                .description("codedby.jst");
        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}
