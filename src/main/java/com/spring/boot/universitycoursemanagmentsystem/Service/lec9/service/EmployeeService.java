package com.spring.boot.universitycoursemanagmentsystem.Service.lec9.service;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec9.DTO.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto save(EmployeeDto employeeDto);

    EmployeeDto update(EmployeeDto employeeDto);

    void remove(Long id);

    List<EmployeeDto> getAllEmployee();

    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto>getEmployee(List<Long> ids);

   List< EmployeeDto> getEmployeeByListOfName(List<String> names);


}
