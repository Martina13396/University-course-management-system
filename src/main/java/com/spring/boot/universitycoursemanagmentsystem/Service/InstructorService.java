package com.spring.boot.universitycoursemanagmentsystem.Service;

import com.spring.boot.universitycoursemanagmentsystem.model.Course;
import com.spring.boot.universitycoursemanagmentsystem.model.Instructor;

import java.util.List;

public interface InstructorService {

    Instructor createInstructor(Instructor instructor);
    List<Instructor> getAllInstructors();
  List<Course> getCoursesTaughtByInstructor(Long instructorId);
}
