package com.spring.boot.universitycoursemanagmentsystem.lec9.mapper;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec9.DTO.EmployeeDto;
import com.spring.boot.universitycoursemanagmentsystem.model.lec9.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto toEmployeeDto(Employee employee);
    Employee toEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> toEmployeeDto(List<Employee> employees);

    List<Employee> toEmployee(List<EmployeeDto> employeeDtos);
}
