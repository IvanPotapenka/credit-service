package by.potapenko.creditservice.builder;


import by.potapenko.creditservice.model.Dto.OfferDataDTO;
import by.potapenko.creditservice.model.Dto.ResponseDataDTO;
import by.potapenko.creditservice.model.enam.OfferStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ResponseOfferDataBuilder {
    public static ResponseDataDTO buildResponseOffer(OfferDataDTO data) {
        return ResponseDataDTO.builder()
                .status(OfferStatus.SUCCESS)
                .actualDateTime(LocalDateTime.now())
                .code("selectionOffer")
                .description("предложение по кредиту")
                .data(data)
                .build();
    }
}
