package by.potapenko.creditservice.model.Dto;


import by.potapenko.creditservice.model.enam.OfferType;
import by.potapenko.creditservice.validation.annotation.NotNullForType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static by.potapenko.creditservice.util.constant.ErrorValidationMessage.FIELD_IS_REQUIRED;
import static by.potapenko.creditservice.util.constant.ErrorValidationMessage.INCORRECT_FORMAT_FIELD_CAN_ONLY_BE_N_OR_Y;
import static by.potapenko.creditservice.util.constant.ErrorValidationMessage.NUMBER_MUST_BE_LESS;
import static by.potapenko.creditservice.util.constant.ErrorValidationMessage.NUMBER_MUST_BE_MORE;
import static by.potapenko.creditservice.util.constant.ErrorValidationMessage.VALUE_CANNOT_BE_NEGATIVE_OR_ZERO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfferDataDTO {

    private UUID clientId;

    @NotNull(message = FIELD_IS_REQUIRED)
    private UUID offerId;

    @NotNull(message = FIELD_IS_REQUIRED)
    private OfferType offerType;

    @NotNull(message = FIELD_IS_REQUIRED)
    private Boolean verificationRequired;

    @Pattern(regexp = "^[YN]$",
            message = INCORRECT_FORMAT_FIELD_CAN_ONLY_BE_N_OR_Y)
    private String proofIncomeRequired;

    private Boolean identityDocumentsRequired;
    private String productSubTypeCode;

    @NotNull(message = FIELD_IS_REQUIRED)
    @Min(value = 1, message = NUMBER_MUST_BE_MORE)
    @Max(value = 12, message = NUMBER_MUST_BE_LESS)
    private Integer term;

    @NotNull(message = FIELD_IS_REQUIRED)
    @Positive(message = VALUE_CANNOT_BE_NEGATIVE_OR_ZERO)
    private BigDecimal rate;

    @NotNull(message = FIELD_IS_REQUIRED)
    @Positive(message = VALUE_CANNOT_BE_NEGATIVE_OR_ZERO)
    private BigDecimal amount;

    @NotNull(message = FIELD_IS_REQUIRED)
    @Positive(message = VALUE_CANNOT_BE_NEGATIVE_OR_ZERO)
    private BigDecimal amountOverLimit;

    @NotNullForType(message = FIELD_IS_REQUIRED)
    private BigDecimal insurancePremium;

    @NotNull(message = FIELD_IS_REQUIRED)
    @Positive(message = VALUE_CANNOT_BE_NEGATIVE_OR_ZERO)
    private BigDecimal commissionAmount;

    @NotNullForType(message = FIELD_IS_REQUIRED)
    private BigDecimal discountRate;

    private BigDecimal refinancingAmount;

    @Valid
    private List<RefinancingCreditDTO> refinancingCredits;
}
