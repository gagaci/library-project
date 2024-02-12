package com.company.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult<E> {

    private final boolean success;

    private E data;

    private List<ErrorData> errors;


    private ApiResult(E data) {
        this.success = true;
        this.data = data;
    }



    private ApiResult(List<ErrorData> errors) {
        this.success = false;
        this.errors = errors;
    }

    public ApiResult() {
        this.success = true;
    }


    public static <T> ApiResult<T> successResponse(T data) {
        return new ApiResult<>(data);
    }

    public static <T> ApiResult<T> successResponse() {
        return new ApiResult<>();
    }


    public static ApiResult<ErrorData> failResponse(String msg, Integer errorCode) {
        return new ApiResult<>(List.of(new ErrorData(errorCode, msg)));
    }


}
