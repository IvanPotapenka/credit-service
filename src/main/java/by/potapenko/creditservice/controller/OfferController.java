package by.potapenko.creditservice.controller;

import by.potapenko.creditservice.model.Dto.OfferDataDTO;
import by.potapenko.creditservice.model.Dto.ResponseDataDTO;
import by.potapenko.creditservice.service.OfferDataService;
import by.potapenko.creditservice.util.UrlPathUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(UrlPathUtil.API + UrlPathUtil.OFFER)
@RequiredArgsConstructor
@Tag(name = "Offer controller", description = "Содержит эндпойнты для работы с заявками на кредит от клиентов")
public class OfferController {

    private final OfferDataService offerService;

    @Operation(summary = "Добавить заявку клиента",
            description = "Позволяет принять данные клиента по кредиту и отправить их в другой сервис")
    @PostMapping(UrlPathUtil.APPLY)
    public ResponseEntity<UUID> sendData(
            @Parameter(description = "Описание данных предложений по кредиту клиента")
            @Valid @RequestBody OfferDataDTO data,
            @RequestHeader("Client-Id") UUID clientId) {
        data.setClientId(clientId);
        log.info("Создание новой заявки: {}", clientId);
        return ResponseEntity.ok(offerService.sendData(data));
    }

    @Operation(summary = "Получить данные предложения по кредиту клиента",
            description = "Позволяет получить данные предложения по кредиту клиента")
    @GetMapping(UrlPathUtil.GET_DATA)
    public ResponseEntity<ResponseDataDTO> getData(@RequestHeader("Client-Id") UUID clientId) {
        log.info("Получение заявки клиента по id: {}", clientId);
        return ResponseEntity.ok(offerService.getData(clientId));
    }
}
