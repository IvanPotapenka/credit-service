package by.potapenko.creditservice.client;


import by.potapenko.creditservice.model.Dto.OfferDataDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.UUID;

import static by.potapenko.creditservice.util.UrlPathUtil.API;
import static by.potapenko.creditservice.util.UrlPathUtil.APPLY;
import static by.potapenko.creditservice.util.UrlPathUtil.DB_SERVICE;
import static by.potapenko.creditservice.util.UrlPathUtil.GET_DATA;


@FeignClient(
        url = "${feign.client.url}",
        name = "${feign.client.name}"
)
@Component
public interface DbServiceClient {

    @PostMapping(path = API + DB_SERVICE + APPLY)
    UUID processData(@RequestBody OfferDataDTO data);

    @GetMapping(path = API + DB_SERVICE + GET_DATA)
    OfferDataDTO getData(@RequestHeader("Client-Id") UUID clientId);
}
