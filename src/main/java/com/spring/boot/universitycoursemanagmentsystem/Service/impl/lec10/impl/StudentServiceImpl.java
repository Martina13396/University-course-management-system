package com.spring.boot.universitycoursemanagmentsystem.Service.impl.lec10.impl;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec10.service.StudentService;
import com.spring.boot.universitycoursemanagmentsystem.Service.lec10.service.dto.StudentDto;
import com.spring.boot.universitycoursemanagmentsystem.lec9.mapper.lec10.mapper.StudentMapper;
import com.spring.boot.universitycoursemanagmentsystem.model.lec10.model.Student;
import com.spring.boot.universitycoursemanagmentsystem.repo.lec10.repo.StudentRepo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    StudentMapper  studentMapper;
    StudentRepo studentRepo;

    public StudentServiceImpl(StudentMapper studentMapper, StudentRepo studentRepo) {
        this.studentMapper = studentMapper;
        this.studentRepo = studentRepo;
    }
    @Override
    public List<StudentDto> getStudentsWithTeachers() {
        List<Student> students = studentRepo.findAll();
        if(CollectionUtils.isEmpty(students)) {
            return new ArrayList<>();
        }
        return students.stream().map(student ->  studentMapper.toStudentDto(student)).collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentWithTeachersById(Long id) {
       Optional<Student> student = studentRepo.findById(id);
       if (!student.isPresent()) {
           throw  new RuntimeException("Student with id " + id + " not found");

       }

       return studentMapper.toStudentDto(student.get());
    }


}
