package by.potapenko.creditservice.exception.response;

import lombok.Builder;

@Builder
public record ApiErrorResponse(String errorCode, String message, String description) {
}
