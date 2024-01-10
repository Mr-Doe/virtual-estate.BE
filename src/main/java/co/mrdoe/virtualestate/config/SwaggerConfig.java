package co.mrdoe.virtualestate.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:/swagger.properties")
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(@Value("${springdoc.api-docs.version}")String openApiVersion) {
        return new OpenAPI()
                .info(new Info()
                        .version(openApiVersion)
                        .title("API - 가상부동산")
                        .description(
                                "## API 구조 \n" +
                                "#### ─ / <br>" +
                                "　├ admin/ <br>" +
                                "　│　├ map/ <br>" +
                                "　│　│　├ dist <br>" +
                                "　│　│　└ dng <br>" +
                                "　│　├ list/ <br>" +
                                "　│　│　├ city <br>" +
                                "　│　│　├ dist <br>" +
                                "　│　│　├ land <br>" +
                                "　│　│　├ dng <br>" +
                                "　│　│　└ ... <br>" +
                                "　│　├ conf/ <br>" +
                                "　│　│　└ land-sale <br>"
                        )
                );
    }


    @Bean
    public GroupedOpenApi adminMapGroup() {
        return  GroupedOpenApi.builder()
                .group("Admin.Map.** 페이지")
                .pathsToMatch("/admin/map/**")
                .build();
    }
    @Bean
    public GroupedOpenApi adminListGroup() {
        return  GroupedOpenApi.builder()
                .group("Admin.List.** 페이지")
                .pathsToMatch("/admin/list/**")
                .build();
    }
    @Bean
    public GroupedOpenApi adminConfGroup() {
        return  GroupedOpenApi.builder()
                .group("Admin.Conf.** 페이지")
                .pathsToMatch("/admin/conf/**")
                .build();
    }

    @Bean public GroupedOpenApi rootGroup() {
        return GroupedOpenApi.builder()
                .group("전체 페이지")
                .pathsToMatch("/**")
                .build();
    }

}
