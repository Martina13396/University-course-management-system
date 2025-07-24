package com.spring.boot.universitycoursemanagmentsystem.controller;

import com.spring.boot.universitycoursemanagmentsystem.Service.InstructorService;
import com.spring.boot.universitycoursemanagmentsystem.model.Course;
import com.spring.boot.universitycoursemanagmentsystem.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstructorController {
    private InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping("create-instructor")
   public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
        return ResponseEntity.ok(instructorService.createInstructor(instructor));
    }
    @GetMapping("instructors")
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        return ResponseEntity.ok(instructorService.getAllInstructors());

    }
    @GetMapping("get-course-ById/{instructorId}")
    public ResponseEntity<List<Course> >getCoursesTaughtByInstructor(@PathVariable Long instructorId) {
        return ResponseEntity.ok(instructorService.getCoursesTaughtByInstructor(instructorId));

}
}
