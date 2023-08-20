package com.productmapper.exceptionhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultErrorHandler {
    @ExceptionHandler(NullPointerException.class) // exception handled
    public String handleFileNotFound(Exception e) {
        return "forward:/html/error/FileNotFound.html";
    }

    // fallback method
    @ExceptionHandler(Exception.class) // exception handled
    public String handleOtherExceptions(Exception e) {
        return "forward:/html/error/Other.html";
    }
}
