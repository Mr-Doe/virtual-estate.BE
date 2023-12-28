package co.mrdoe.virtualestate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/datasource.properties")
public class DatabaseConfig {
}
