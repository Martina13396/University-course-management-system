package com.spring.boot.universitycoursemanagmentsystem.Service.lec9.DTO;

import com.spring.boot.universitycoursemanagmentsystem.model.lec9.model.Email;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {


    private Long id;


    @NotBlank(message = "name must be not empty")
    private String name;

    @Min(value = 16 , message = "age must be greater than 15")
    @Max(value = 39 , message = "age must be less than 40")
    private int age;
     @Min(value = 5001 ,message = "salary must be greater than 5000")
     @Max(value = 9999 , message = "salary must be less than 10000")
    private double salary;


    List<Email> emails = new ArrayList<>();
}
