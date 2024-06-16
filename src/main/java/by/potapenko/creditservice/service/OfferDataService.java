package by.potapenko.creditservice.service;


import by.potapenko.creditservice.builder.ResponseOfferDataBuilder;
import by.potapenko.creditservice.client.DbServiceClient;
import by.potapenko.creditservice.model.Dto.OfferDataDTO;
import by.potapenko.creditservice.model.Dto.ResponseDataDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OfferDataService {

    private final DbServiceClient dbServiceClient;

    public UUID sendData(OfferDataDTO data) {
        return dbServiceClient.processData(data);
    }

    public ResponseDataDTO getData(UUID clientId) {
        return ResponseOfferDataBuilder.buildResponseOffer(dbServiceClient.getData(clientId));
    }
}
