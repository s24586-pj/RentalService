package RentalService.RentalService;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI apiDocConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("MoviesService")
                        .description("RentalService Api ")
                        .version("0.0.1")
                        .contact(new Contact()
                                .name("example")
                                .email("SuperApiMoje@gmail.com")));
    }
}
