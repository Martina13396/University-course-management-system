package com.spring.boot.universitycoursemanagmentsystem.lec9.mapper.lec10.mapper;


import com.spring.boot.universitycoursemanagmentsystem.Service.lec10.service.dto.TeacherDto;
import com.spring.boot.universitycoursemanagmentsystem.model.lec10.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {StudentMapper.class})
public interface TeacherMapper {

    TeacherMapper TEACHER_MAPPER = Mappers.getMapper(TeacherMapper.class);

    Teacher toTeacher(TeacherDto teacherDto);

    TeacherDto toTeacherDto(Teacher teacher);

    List<Teacher> toTeacherList(List<TeacherDto> teacherDtos);

    List<TeacherDto> toTeacherDtoList(List<Teacher> teachers);
}
