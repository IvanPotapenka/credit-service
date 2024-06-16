package by.potapenko.creditservice.model.Dto;

import by.potapenko.creditservice.model.enam.OfferStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDataDTO {
        private OfferStatus status;
        private LocalDateTime actualDateTime;
        private String code;
        private String description;
        private OfferDataDTO data;
}
