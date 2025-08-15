package com.spring.boot.universitycoursemanagmentsystem.Service.lec10.service;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec10.service.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getStudentsWithTeachers();

     StudentDto getStudentWithTeachersById(Long id);
}
