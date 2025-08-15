package com.spring.boot.universitycoursemanagmentsystem.Service.lec11.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Long id;

    @NotNull(message = "text can not be null")
    @Size(min = 20 ,message = "text must be at least 20 characters")
    private String text;

    private String imagePath;
}
