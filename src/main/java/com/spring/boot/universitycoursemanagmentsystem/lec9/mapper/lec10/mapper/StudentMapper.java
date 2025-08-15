package com.spring.boot.universitycoursemanagmentsystem.lec9.mapper.lec10.mapper;

;
import com.spring.boot.universitycoursemanagmentsystem.Service.lec10.service.dto.StudentDto;
import com.spring.boot.universitycoursemanagmentsystem.model.lec10.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public  interface StudentMapper {

    StudentMapper STUDENT_MAPPER = Mappers.getMapper(StudentMapper.class);

    Student toStudent(StudentDto studentDto);

    StudentDto toStudentDto(Student student);

    List<Student> toStudentList(List<StudentDto> studentDtos);

    List<StudentDto> toStudentDtoList(List<Student> students);
}
