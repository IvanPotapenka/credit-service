package by.potapenko.creditservice.controller;

import by.potapenko.creditservice.service.OfferDataService;
import by.potapenko.creditservice.util.UrlPathUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static by.potapenko.creditservice.data.TestData.clientId;
import static by.potapenko.creditservice.data.TestData.offerDataDTO;
import static by.potapenko.creditservice.data.TestData.responseDataDTO;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(OfferController.class)
public class OfferControllerTest {

    @MockBean
    private OfferDataService offerDataService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void givenValidData_whenSendData_thanOk() throws Exception {
        when(offerDataService.sendData(offerDataDTO)).thenReturn(clientId);
        offerDataDTO.setClientId(clientId);

        mockMvc.perform(post(UrlPathUtil.API + UrlPathUtil.OFFER + UrlPathUtil.APPLY)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(offerDataDTO))
                        .header("Client-id", clientId))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void givenInvalidData_whenSendInvalidData_thenNotFound() throws Exception {
        offerDataDTO.setProofIncomeRequired("invalid");
        mockMvc.perform(post(UrlPathUtil.API + UrlPathUtil.OFFER + UrlPathUtil.APPLY)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(offerDataDTO))
                        .header("Client-id", clientId))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void givenId_whenGetData_thenOk() throws Exception {
        when(offerDataService.getData(any(UUID.class))).thenReturn(responseDataDTO);
        mockMvc.perform(get(UrlPathUtil.API + UrlPathUtil.OFFER + UrlPathUtil.GET_DATA)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Client-id", clientId))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", equalTo("SUCCESS")))
                .andExpect(status().isOk());
    }
}
