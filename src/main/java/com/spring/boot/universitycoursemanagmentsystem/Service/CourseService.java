package com.spring.boot.universitycoursemanagmentsystem.Service;

import com.spring.boot.universitycoursemanagmentsystem.model.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);
    List<Course> getAllCourses();
    Course assignCourseToInstructor(Long courseId, Long instructorId);
}
