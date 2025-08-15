package com.spring.boot.universitycoursemanagmentsystem.model.lec10.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "teachers" , cascade = CascadeType.PERSIST , fetch = FetchType.EAGER)
    List<Student> students = new ArrayList<>();
}
