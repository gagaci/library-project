package com.company.exception;

import com.company.payload.ApiResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ApiResult<?>> exceptionHandler(AppException ex) {
        ApiResult<?> apiResult = ApiResult.failResponse(ex.getMessage(), ex.getStatus().value());
        return new ResponseEntity<>(apiResult, ex.getStatus());
    }
}
