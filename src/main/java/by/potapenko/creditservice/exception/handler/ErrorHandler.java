package by.potapenko.creditservice.exception.handler;

import by.potapenko.creditservice.builder.ValidationErrorResponseBuilder;
import by.potapenko.creditservice.builder.ViolationBuilder;
import by.potapenko.creditservice.exception.response.ApiErrorResponse;
import by.potapenko.creditservice.validation.ValidationErrorResponse;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static by.potapenko.creditservice.builder.ApiResponseBuilder.responseBuild;
import static by.potapenko.creditservice.util.constant.ErrorResponseMessage.CHECK_THE_CORRECTNESS_OF_THE_ENTERED_DATA;
import static by.potapenko.creditservice.util.constant.ErrorResponseMessage.CHECK_YOUR_INTERNET_CONNECTION_OR_SERVER;
import static by.potapenko.creditservice.util.constant.ErrorResponseMessage.NOT_FOUND;
import static by.potapenko.creditservice.util.constant.ErrorResponseMessage.SERVER_CONNECTION_ERROR;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(FeignException.class)
    private ResponseEntity<ApiErrorResponse> handleFeignStatusException(FeignException e) {
        if (e.status() == HttpStatus.NOT_FOUND.value()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(responseBuild(String.valueOf(e.status()), NOT_FOUND, e.getMessage()));
        }
        if (e.status() == HttpStatus.BAD_REQUEST.value()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(responseBuild(String.valueOf(e.status()), CHECK_THE_CORRECTNESS_OF_THE_ENTERED_DATA, e.getMessage()));
        }
        if (e.status() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseBuild(String.valueOf(e.status()), CHECK_YOUR_INTERNET_CONNECTION_OR_SERVER, e.getMessage()));
        }
        return ResponseEntity
                .status(HttpStatus.GATEWAY_TIMEOUT)
                .body(responseBuild(String.valueOf(e.status()), SERVER_CONNECTION_ERROR, e.getMessage()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        var violations = e.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> ViolationBuilder.buildViolation(error.getField(), error.getDefaultMessage()))
                .toList();
        return ValidationErrorResponseBuilder.buildErrorResponse(violations);
    }

}
