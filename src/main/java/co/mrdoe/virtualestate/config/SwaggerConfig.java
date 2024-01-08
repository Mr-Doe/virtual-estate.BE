package co.mrdoe.virtualestate.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/swagger.properties")
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(@Value("${springdoc.api-docs.version}")String openApiVersion) {
        Info info = new Info()
                .version(openApiVersion)
                .title("API - 가상부동산")
                .license(new License()
                        .name("Apache License Version 2.0")
                        .url("http://www.apache.org/licenses/LICENSE-2.0"));

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }

    @Bean
    public GroupedOpenApi adminGroup() {
        return  GroupedOpenApi.builder()
                .group("Admin 페이지")
                .pathsToMatch("/admin/**")
                .build();
    }

    @Bean public GroupedOpenApi rootGroup() {
        return GroupedOpenApi.builder()
                .group("전체 페이지")
                .pathsToMatch("/**")
                .build();
    }

}
