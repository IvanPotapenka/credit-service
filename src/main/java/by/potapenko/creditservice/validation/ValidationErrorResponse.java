package by.potapenko.creditservice.validation;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ValidationErrorResponse {
    private final List<Violation> violations;
}
