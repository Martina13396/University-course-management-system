package com.spring.boot.universitycoursemanagmentsystem.Service;

import com.spring.boot.universitycoursemanagmentsystem.model.Students;

import java.util.List;


public interface StudentsService {
    Students createStudent (Students student);
    List<Students> getAllStudents();
    Students getStudentById(Long id);
    Students registerStudentToCourse(Long StudentId , Long courseId);
}
