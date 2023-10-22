package pl.hosannaponglish.dictionaryservice;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author Bartosz Średziński
 * created on 22.10.2023
 */

@Component
public class SwaggerConfiguration{

    @Bean
    public OpenAPI swaggerConfiguration(){
        return new OpenAPI().info(new Info().title("Hosanna Dictionary Api")
                .description("Service for language dictionaries")
                .version("v0.1")
                .license(new License().name("Apache 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }

}
