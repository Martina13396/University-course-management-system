package com.spring.boot.universitycoursemanagmentsystem.Service.impl;

import com.spring.boot.universitycoursemanagmentsystem.Service.InstructorService;
import com.spring.boot.universitycoursemanagmentsystem.model.Course;
import com.spring.boot.universitycoursemanagmentsystem.model.Instructor;
import com.spring.boot.universitycoursemanagmentsystem.repo.CourseRepo;
import com.spring.boot.universitycoursemanagmentsystem.repo.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    InstructorRepo instructorRepo;
    CourseRepo courseRepo;
    @Autowired
    public InstructorServiceImpl(InstructorRepo instructorRepo, CourseRepo courseRepo) {
        this.instructorRepo = instructorRepo;
    }
    @Override
    public Instructor createInstructor(Instructor instructor) {
        if (instructor.getId() != null) {
            throw new RuntimeException("Instructor id must be null");
        } else {
            return instructorRepo.save(instructor);
        }
    }
    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepo.findAll();
    }

    @Override
    public List<Course> getCoursesTaughtByInstructor(Long instructorId) {
        Instructor instructor = instructorRepo.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found wit id " + instructorId));
          return instructor.getCourses();
    }
}
