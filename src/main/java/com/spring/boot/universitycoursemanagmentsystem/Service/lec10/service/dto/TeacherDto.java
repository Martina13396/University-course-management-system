package com.spring.boot.universitycoursemanagmentsystem.Service.lec10.service.dto;

import com.spring.boot.universitycoursemanagmentsystem.model.lec10.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {

    private Long id;

    private String name;

    List<StudentDto> students  = new ArrayList<>();

}
