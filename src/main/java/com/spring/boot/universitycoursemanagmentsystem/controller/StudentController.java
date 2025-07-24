package com.spring.boot.universitycoursemanagmentsystem.controller;

import com.spring.boot.universitycoursemanagmentsystem.Service.StudentService;
import com.spring.boot.universitycoursemanagmentsystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("create-student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @GetMapping("students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("get-student-ById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping("register-student/{studentId}/{courseId}")
    public ResponseEntity<Student> registerStudentToCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        return ResponseEntity.ok(studentService.registerStudentToCourse(courseId, studentId));
    }
}
