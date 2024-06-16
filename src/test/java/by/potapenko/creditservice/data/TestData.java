package by.potapenko.creditservice.data;

import by.potapenko.creditservice.model.enam.OfferStatus;
import by.potapenko.creditservice.model.enam.OfferType;
import by.potapenko.creditservice.model.Dto.OfferDataDTO;
import by.potapenko.creditservice.model.Dto.RefinancingCreditDTO;
import by.potapenko.creditservice.model.Dto.ResponseDataDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class TestData {

    public static UUID clientId = UUID.randomUUID();

    public static RefinancingCreditDTO refinancingCreditDTO = RefinancingCreditDTO.builder()
            .amount(BigDecimal.valueOf(20000))
            .orderNum(111L)
            .build();

    public static OfferDataDTO offerDataDTO = OfferDataDTO.builder()
        .offerId(UUID.randomUUID())
        .offerType(OfferType.STANDART)
        .verificationRequired(true)
        .proofIncomeRequired("Y")
        .identityDocumentsRequired(false)
        .productSubTypeCode("subtype")
        .term(12)
        .rate(BigDecimal.valueOf(12.5))
        .amount(BigDecimal.valueOf(500000))
        .amountOverLimit(BigDecimal.valueOf(450000))
        .insurancePremium(BigDecimal.valueOf(15000))
        .commissionAmount(BigDecimal.valueOf(5000))
        .discountRate(BigDecimal.valueOf(1.5))
        .refinancingAmount(BigDecimal.valueOf(100000))
        .refinancingCredits(List.of(refinancingCreditDTO))
        .build();

    public static ResponseDataDTO responseDataDTO = ResponseDataDTO.builder()
            .status(OfferStatus.SUCCESS)
            .actualDateTime(LocalDateTime.now())
            .code("selectionOffer")
            .description("предложение по кредиту")
            .data(offerDataDTO)
            .build();
}
