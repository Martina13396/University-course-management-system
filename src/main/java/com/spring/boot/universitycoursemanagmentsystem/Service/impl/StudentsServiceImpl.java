package com.spring.boot.universitycoursemanagmentsystem.Service.impl;

import com.spring.boot.universitycoursemanagmentsystem.Service.StudentsService;
import com.spring.boot.universitycoursemanagmentsystem.model.Course;
import com.spring.boot.universitycoursemanagmentsystem.model.Students;
import com.spring.boot.universitycoursemanagmentsystem.repo.CourseRepo;
import com.spring.boot.universitycoursemanagmentsystem.repo.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsServiceImpl implements StudentsService {

    private final StudentsRepo studentRepo;
    private final CourseRepo courseRepo;

    @Autowired
    public StudentsServiceImpl(StudentsRepo studentRepo, CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }
    @Override
    public Students createStudent(Students student) {
        if(student.getId() != null) {
            throw new RuntimeException("student id must be null");
        }
        return studentRepo.save(student);
    }

    @Override
    public List<Students> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Students getStudentById(Long id) {
       Optional<Students> studentOptional = studentRepo.findById(id);
               if(studentOptional.isEmpty()) {
                  return null;
               }else {
                   return studentRepo.findById(id).get();
               }
    }

    @Override
    public Students registerStudentToCourse(Long StudentId, Long courseId) {

        Students student = studentRepo.findById(StudentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepo.findById(courseId)
                .orElseThrow(()-> new RuntimeException("course not found"));
        student.getCourses().add(course);
        course.getStudents().add(student);
        studentRepo.save(student);
        courseRepo.save(course);
        return student;
    }
}
