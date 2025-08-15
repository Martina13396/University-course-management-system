package com.spring.boot.universitycoursemanagmentsystem.controller.vm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    List<String> messages;
}
