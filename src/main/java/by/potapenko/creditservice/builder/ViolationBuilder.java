package by.potapenko.creditservice.builder;

import by.potapenko.creditservice.validation.Violation;
import org.springframework.stereotype.Component;

@Component
public class ViolationBuilder {
    public static Violation buildViolation(String fieldName, String massage) {
        return Violation.builder()
                .fieldName(fieldName)
                .message(massage)
                .build();
    }
}
