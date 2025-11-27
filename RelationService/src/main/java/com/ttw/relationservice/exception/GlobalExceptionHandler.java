package com.ttw.relationservice.exception;

import com.ttw.relationservice.payload.response.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler extends Exception {

    @ExceptionHandler(value = AlreadyBlockedException.class)
    public ApiResponse<String> handleAlreadyBlockedException(AlreadyBlockedException e) {
        return ApiResponse.failure( "this user is already blocked",null);
    }
}
