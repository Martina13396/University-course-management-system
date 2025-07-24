package com.spring.boot.universitycoursemanagmentsystem.Service;

import com.spring.boot.universitycoursemanagmentsystem.model.Student;
import jakarta.persistence.Entity;

import java.util.List;


public interface StudentService {
    Student createStudent (Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student registerStudentToCourse(Long StudentId , Long courseId);
}
