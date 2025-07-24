package com.spring.boot.universitycoursemanagmentsystem.Service.impl;

import com.spring.boot.universitycoursemanagmentsystem.Service.CourseService;
import com.spring.boot.universitycoursemanagmentsystem.model.Course;
import com.spring.boot.universitycoursemanagmentsystem.model.Instructor;
import com.spring.boot.universitycoursemanagmentsystem.repo.CourseRepo;
import com.spring.boot.universitycoursemanagmentsystem.repo.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;
    private final InstructorRepo instructorRepo;

    @Autowired
    public CourseServiceImpl(CourseRepo courseRepo, InstructorRepo instructorRepo) {
        this.courseRepo = courseRepo;
        this.instructorRepo = instructorRepo;
    }
    @Override
    public Course createCourse(Course course) {
        if(course.getId() != null) {
            throw new RuntimeException("course id must be null");
        }
        return courseRepo.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course assignCourseToInstructor(Long courseId, Long instructorId) {
        Course course = courseRepo.findById(courseId).
                orElseThrow(() -> new RuntimeException("course not found with id " + courseId));

        Instructor instructor = instructorRepo.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("instructor not found by id" + instructorId));
        course.setInstructor(instructor);

        return courseRepo.save(course);
    }
}
