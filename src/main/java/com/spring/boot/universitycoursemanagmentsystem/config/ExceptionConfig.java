package com.spring.boot.universitycoursemanagmentsystem.config;

import com.spring.boot.universitycoursemanagmentsystem.controller.vm.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ExceptionResponse>handleException(Exception exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage()));
    }
}
