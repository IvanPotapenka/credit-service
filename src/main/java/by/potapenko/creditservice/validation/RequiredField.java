package by.potapenko.creditservice.validation;

import by.potapenko.creditservice.validation.annotation.NotNullForType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
@RequiredArgsConstructor
public class RequiredField implements ConstraintValidator<NotNullForType, BigDecimal> {

    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
        return value != null;
    }
}
