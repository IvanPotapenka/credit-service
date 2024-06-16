package by.potapenko.creditservice.builder;

import by.potapenko.creditservice.validation.ValidationErrorResponse;
import by.potapenko.creditservice.validation.Violation;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ValidationErrorResponseBuilder {

    public static ValidationErrorResponse buildErrorResponse(List<Violation> violations) {
        return ValidationErrorResponse.builder()
                .violations(violations)
                .build();
    }
}
