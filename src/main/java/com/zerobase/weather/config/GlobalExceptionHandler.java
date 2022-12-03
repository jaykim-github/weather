package com.zerobase.weather.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler { // 전역 예외


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500번대 에러, 서버상의 문제
    @ExceptionHandler(Exception.class)
    public Exception handleAllException() {
        System.out.println("error from GlobalExceptionHandler");
        //에러별로 예외처리를 할 수 있는 로직을 넣을 수 있다.

        return new Exception();
    }
}
