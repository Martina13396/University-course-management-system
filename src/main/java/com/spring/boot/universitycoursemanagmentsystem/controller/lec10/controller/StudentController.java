package com.spring.boot.universitycoursemanagmentsystem.controller.lec10.controller;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec10.service.StudentService;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec10.service.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("students-teachers")
    ResponseEntity<List<StudentDto>> getStudentsWithTeachers(){
        return ResponseEntity.ok(studentService.getStudentsWithTeachers());
    }

    @GetMapping("student-teachers/byId/{id}")
    ResponseEntity<StudentDto> getStudentWithTeachersById(@PathVariable Long id){

        return ResponseEntity.ok(studentService.getStudentWithTeachersById(id));
    }
}
