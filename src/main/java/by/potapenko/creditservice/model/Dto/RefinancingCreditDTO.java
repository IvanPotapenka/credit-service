package by.potapenko.creditservice.model.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static by.potapenko.creditservice.util.constant.ErrorValidationMessage.FIELD_IS_REQUIRED;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RefinancingCreditDTO {

    @NotNull(message = FIELD_IS_REQUIRED)
    private Long orderNum;

    @NotNull(message = FIELD_IS_REQUIRED)
    private BigDecimal amount;
}
