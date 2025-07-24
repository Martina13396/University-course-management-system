package com.spring.boot.universitycoursemanagmentsystem.Service.impl;

import com.spring.boot.universitycoursemanagmentsystem.Service.StudentService;
import com.spring.boot.universitycoursemanagmentsystem.model.Course;
import com.spring.boot.universitycoursemanagmentsystem.model.Student;
import com.spring.boot.universitycoursemanagmentsystem.repo.CourseRepo;
import com.spring.boot.universitycoursemanagmentsystem.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo, CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }
    @Override
    public Student createStudent(Student student) {
        if(student.getId() != null) {
            throw new RuntimeException("student id must be null");
        }
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
       Optional<Student> studentOptional = studentRepo.findById(id);
               if(studentOptional.isEmpty()) {
                  return null;
               }else {
                   return studentRepo.findById(id).get();
               }
    }

    @Override
    public Student registerStudentToCourse(Long StudentId, Long courseId) {

        Student student = studentRepo.findById(StudentId)
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
