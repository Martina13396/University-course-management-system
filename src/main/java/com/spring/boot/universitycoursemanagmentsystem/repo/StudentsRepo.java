package com.spring.boot.universitycoursemanagmentsystem.repo;

import com.spring.boot.universitycoursemanagmentsystem.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepo extends JpaRepository<Students, Long> {


}
