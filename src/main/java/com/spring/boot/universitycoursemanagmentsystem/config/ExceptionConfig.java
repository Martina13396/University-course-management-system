package com.spring.boot.universitycoursemanagmentsystem.config;

import com.spring.boot.universitycoursemanagmentsystem.controller.vm.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionConfig {




@ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleMethodException (MethodArgumentNotValidException exception){
        List<String> messages = exception.getBindingResult().getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());
        return ResponseEntity.badRequest().body(new ExceptionResponse(messages));
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ExceptionResponse>handleException(RuntimeException exception) {
    List<String> messages = new ArrayList<>();
    messages.add(exception.getMessage());
        return ResponseEntity.badRequest().body(new ExceptionResponse(messages));
    }
}
