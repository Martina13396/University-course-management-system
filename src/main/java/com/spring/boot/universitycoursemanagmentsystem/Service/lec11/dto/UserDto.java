package com.spring.boot.universitycoursemanagmentsystem.Service.lec11.dto;

import com.spring.boot.universitycoursemanagmentsystem.model.lec11.model.Post;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @Size(min = 8, message = "name length must be greater than 7")
    private String name;
    @Min(value = 18, message = "age must be at least 18")
    private int age;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])(A-Za-z\\d@$!%*?&]){6,}$"
    , message = "password must have upper case , lower case ,number and special character  ")
    private String password;

    List<PostDto> posts;
}
