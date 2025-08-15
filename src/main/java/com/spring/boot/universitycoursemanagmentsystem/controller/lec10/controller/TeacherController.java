package com.spring.boot.universitycoursemanagmentsystem.controller.lec10.controller;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec10.service.TeacherService;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec10.service.dto.TeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {

    TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("teachers-students")
   ResponseEntity< List<TeacherDto>> getTeachers(){
        return ResponseEntity.ok(teacherService.getTeachers());

    }

    @GetMapping("teachers-students/byId/{id}")
    ResponseEntity<TeacherDto> getTeacherWithStudentsById(@PathVariable Long id){

        return ResponseEntity.ok(teacherService.getTeacherWithStudentsById(id));
    }
}
