package com.spring.boot.universitycoursemanagmentsystem.controller;

import com.spring.boot.universitycoursemanagmentsystem.Service.StudentsService;
import com.spring.boot.universitycoursemanagmentsystem.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentsController {
    private StudentsService studentService;

    @Autowired
    public StudentsController(StudentsService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("create-student")
    public ResponseEntity<Students> createStudent(@RequestBody Students student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @GetMapping("students")
    public ResponseEntity<List<Students>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("get-student-ById/{id}")
    public ResponseEntity<Students> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping("register-student/{studentId}/{courseId}")
    public ResponseEntity<Students> registerStudentToCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        return ResponseEntity.ok(studentService.registerStudentToCourse(courseId, studentId));
    }
}
