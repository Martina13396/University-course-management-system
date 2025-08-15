package com.spring.boot.universitycoursemanagmentsystem.Service.impl.lec9.impl;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec9.DTO.EmployeeDto;
import com.spring.boot.universitycoursemanagmentsystem.Service.lec9.service.EmployeeService;
import com.spring.boot.universitycoursemanagmentsystem.controller.lec9.controller.EmployeeController;
import com.spring.boot.universitycoursemanagmentsystem.lec9.mapper.EmployeeMapper;
import com.spring.boot.universitycoursemanagmentsystem.model.lec9.model.Employee;
import com.spring.boot.universitycoursemanagmentsystem.repo.lec9.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepo  employeeRepo;
    EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo, EmployeeMapper employeeMapper) {
        this.employeeRepo = employeeRepo;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        if (Objects.nonNull(employeeDto.getId())) {
            throw new RuntimeException("Employee id must be null");
        }
        Employee employee = employeeMapper.toEmployee(employeeDto);
        employee= employeeRepo.save(employee);
        employeeDto.setId(employee.getId());
        return employeeDto;
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {
        if (Objects.isNull(employeeDto.getId())) {
            throw new RuntimeException("Employee id must not be null");
        }
        Employee employee = employeeMapper.toEmployee(employeeDto);
        employee = employeeRepo.save(employee);
        return employeeDto;
    }

    @Override
    public void remove(Long id) {

        employeeRepo.deleteById(id);

    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepo.findAll();
        if(CollectionUtils.isEmpty(employees)){
            return new ArrayList<>();
        }

        return  employees.stream().map(employee -> employeeMapper.toEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        if(!employeeOptional.isPresent()){
            throw new RuntimeException("Employee of id " + id + " not found");
        }
        return employeeMapper.toEmployeeDto(employeeOptional.get());
    }

    @Override
    public List<EmployeeDto> getEmployee(List<Long> ids) {

        List<Employee> employees = employeeRepo.findAllById(ids);
        if(CollectionUtils.isEmpty(employees)){
            return new ArrayList<>();
        }
        return employees.stream().map(employee -> employeeMapper.toEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> getEmployeeByListOfName(List<String> names) {
        Optional<List<Employee>> employeesOptional = employeeRepo.findByNameIn(names);
        if (!employeesOptional.isPresent()) {
            return new ArrayList<>();
        }
        return employeesOptional.get().stream().map(employeeMapper::toEmployeeDto).collect(Collectors.toList());
    }
}

