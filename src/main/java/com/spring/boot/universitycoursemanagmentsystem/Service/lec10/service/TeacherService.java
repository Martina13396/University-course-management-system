package com.spring.boot.universitycoursemanagmentsystem.Service.lec10.service;


import com.spring.boot.universitycoursemanagmentsystem.Service.lec10.service.dto.TeacherDto;
import com.spring.boot.universitycoursemanagmentsystem.model.lec10.model.Teacher;

import java.util.List;

public interface TeacherService {

    List<TeacherDto> getTeachers();

   TeacherDto getTeacherWithStudentsById(Long id);
}
