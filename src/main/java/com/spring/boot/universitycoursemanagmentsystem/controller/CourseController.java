package com.spring.boot.universitycoursemanagmentsystem.controller;

import com.spring.boot.universitycoursemanagmentsystem.Service.CourseService;
import com.spring.boot.universitycoursemanagmentsystem.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("create-course")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.createCourse(course));
    }

    @GetMapping("courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PostMapping("assign-course/{courseId}/{instructorId}")
    public ResponseEntity<Course> assignCourseToInstructor(@PathVariable Long courseId, @PathVariable Long instructorId) {
        return ResponseEntity.ok(courseService.assignCourseToInstructor(courseId ,instructorId));
    }

}
