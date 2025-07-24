package com.spring.boot.universitycoursemanagmentsystem.repo;

import com.spring.boot.universitycoursemanagmentsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {


}
