package com.spring.boot.universitycoursemanagmentsystem.model.lec9.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private int age;

    private double salary;

    @OneToMany(mappedBy = "employee" ,  cascade = CascadeType.ALL)
    List<Email> emails = new ArrayList<>();
}
