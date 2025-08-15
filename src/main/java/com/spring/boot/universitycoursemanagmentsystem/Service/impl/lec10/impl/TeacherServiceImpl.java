package com.spring.boot.universitycoursemanagmentsystem.Service.impl.lec10.impl;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec10.service.TeacherService;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec10.service.dto.TeacherDto;
import com.spring.boot.universitycoursemanagmentsystem.lec9.mapper.lec10.mapper.TeacherMapper;
import com.spring.boot.universitycoursemanagmentsystem.model.lec10.model.Teacher;
import com.spring.boot.universitycoursemanagmentsystem.repo.lec10.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {
    TeacherRepo teacherRepo;
    TeacherMapper  teacherMapper;

    @Autowired
    public TeacherServiceImpl(TeacherRepo teacherRepo, TeacherMapper teacherMapper) {
        this.teacherRepo = teacherRepo;
        this.teacherMapper = teacherMapper;
    }

    @Override
    public List<TeacherDto> getTeachers() {
        List<Teacher> teachers = teacherRepo.findAll();
        if(CollectionUtils.isEmpty(teachers)) {
            return new ArrayList<>();
        }
        return teachers.stream().map(teacher -> teacherMapper.toTeacherDto(teacher)).collect(Collectors.toList());
    }

    @Override
    public TeacherDto getTeacherWithStudentsById(Long id) {
       Optional<Teacher> teacherOptional = teacherRepo.findById(id);

       if(!teacherOptional.isPresent()) {
           throw new RuntimeException("Teacher with id " + id + " not found");
       }
       return teacherMapper.toTeacherDto(teacherOptional.get());
    }
}
