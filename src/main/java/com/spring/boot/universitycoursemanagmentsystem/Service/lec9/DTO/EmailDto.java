package com.spring.boot.universitycoursemanagmentsystem.Service.lec9.DTO;

import com.spring.boot.universitycoursemanagmentsystem.model.lec9.model.Employee;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {
    private Long Id;

    @NotBlank(message = "email type must be not empty")
    private String name;

    @Email(message = "content must be valid email address")
    private String content;



}
