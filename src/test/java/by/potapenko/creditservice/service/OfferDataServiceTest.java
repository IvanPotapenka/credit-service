package by.potapenko.creditservice.service;

import by.potapenko.creditservice.client.DbServiceClient;
import by.potapenko.creditservice.model.Dto.ResponseDataDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static by.potapenko.creditservice.data.TestData.clientId;
import static by.potapenko.creditservice.data.TestData.offerDataDTO;
import static by.potapenko.creditservice.data.TestData.responseDataDTO;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OfferDataServiceTest {

    @Mock
    private DbServiceClient dbServiceClient;

    @InjectMocks
    private OfferDataService offerDataService;

    @Test
    void whenProcessDataInvoked_thenExpectOfferDataIsReturned() {
        when(offerDataService.sendData(offerDataDTO)).thenReturn(clientId);
        UUID id = offerDataService.sendData(offerDataDTO);
        Assertions.assertThat(id).isNotNull();
        Assertions.assertThat(id).isEqualTo(clientId);
        verify(dbServiceClient).processData(offerDataDTO);
    }

    @Test
    void whenGetDataInvoked_thenExpectResponseDataIsReturned() {
        when(dbServiceClient.getData(clientId)).thenReturn(offerDataDTO);
        ResponseDataDTO dataDTO = offerDataService.getData(clientId);
        Assertions.assertThat(dataDTO).isNotNull();
        Assertions.assertThat(dataDTO.getStatus()).isEqualTo(responseDataDTO.getStatus());
        verify(dbServiceClient).getData(clientId);
    }
}
