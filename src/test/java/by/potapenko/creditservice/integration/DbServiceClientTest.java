package by.potapenko.creditservice.integration;

import by.potapenko.creditservice.controller.OfferController;
import by.potapenko.creditservice.integration.wiremock.WiremockConfig;
import by.potapenko.creditservice.util.UrlPathUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Objects;

import static by.potapenko.creditservice.data.TestData.clientId;
import static by.potapenko.creditservice.data.TestData.offerDataDTO;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class DbServiceClientTest extends WiremockConfig {

    @Autowired
    private OfferController offerController;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void whenGetClientIdInvoked_thenOk() throws JsonProcessingException {
        wm.stubFor(WireMock.get(UrlPathUtil.API + UrlPathUtil.DB_SERVICE + UrlPathUtil.GET_DATA)
                 .willReturn(aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", "application/json")
                        .withBody(objectMapper.writeValueAsString(offerDataDTO))));
        assertThat(Objects.requireNonNull(offerController.getData(clientId)
                .getBody()).getData()).isEqualTo(offerDataDTO);

    }

    @Test
    void whenSendDataInvoked_thenExpectDataIsReturned() throws JsonProcessingException {
        offerDataDTO.setClientId(clientId);
        String data = objectMapper.writeValueAsString(offerDataDTO);

        wm.stubFor(post(UrlPathUtil.API + UrlPathUtil.DB_SERVICE + UrlPathUtil.APPLY)
                        .withRequestBody(equalToJson(data))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", "application/json")
                        .withBody("\"" + clientId.toString() + "\"")));
        var response = offerController.sendData(offerDataDTO, clientId);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(clientId);
    }
}
