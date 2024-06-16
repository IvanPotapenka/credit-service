package by.potapenko.creditservice.builder;

import by.potapenko.creditservice.exception.response.ApiErrorResponse;
import org.springframework.stereotype.Component;

@Component
public class ApiResponseBuilder {
    public static ApiErrorResponse responseBuild(String code, String message, String description) {
        return ApiErrorResponse.builder()
                .errorCode(code)
                .message(message)
                .description(description)
                .build();
    }
}
