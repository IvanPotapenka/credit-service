package by.potapenko.creditservice.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Credit service",
                description = "Credit", version = "1.0.0",
                contact = @Contact(
                        name = "Potapenko Ivan",
                        email = "puivan@gmail.com"
                )
        )
)
public class OpenApiConfig {
}
