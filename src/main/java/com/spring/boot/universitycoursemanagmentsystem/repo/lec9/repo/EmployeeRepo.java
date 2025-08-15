package com.spring.boot.universitycoursemanagmentsystem.repo.lec9.repo;

import com.spring.boot.universitycoursemanagmentsystem.model.lec9.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Optional<List<Employee>> findByNameIn(List<String>names);
}
