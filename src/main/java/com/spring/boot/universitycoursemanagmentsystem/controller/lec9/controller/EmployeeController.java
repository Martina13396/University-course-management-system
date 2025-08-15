package com.spring.boot.universitycoursemanagmentsystem.controller.lec9.controller;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec9.DTO.EmployeeDto;
import com.spring.boot.universitycoursemanagmentsystem.Service.lec9.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class EmployeeController {
    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("save-employee")
    ResponseEntity<EmployeeDto> save(@RequestBody @Valid EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.save(employeeDto));
    }

    @PutMapping("update-employee")
    ResponseEntity<EmployeeDto> update(@RequestBody @Valid EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.update(employeeDto));

    }

     @DeleteMapping("delete-employee")
    ResponseEntity<Void> remove(Long id){

        if (Objects.nonNull(id)) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }

     }

     @GetMapping("all-employees")
    ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        return ResponseEntity.ok(employeeService.getAllEmployee());

     }

     @GetMapping("employee-byId/{id}")
    ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok( employeeService.getEmployeeById(id));
     }

     @GetMapping("employees-byIds/{ids}")
     ResponseEntity<List<EmployeeDto>>getEmployee(@PathVariable List<Long> ids){
        return ResponseEntity.ok(employeeService.getEmployee(ids));

    }

    @GetMapping("employees-byNames/{names}")
    ResponseEntity<List< EmployeeDto>> getEmployeeByListOfName(@PathVariable List<String> names){
        return ResponseEntity.ok(employeeService.getEmployeeByListOfName(names));

    }


}
