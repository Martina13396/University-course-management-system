package com.spring.boot.universitycoursemanagmentsystem.repo.lec10.repo;

import com.spring.boot.universitycoursemanagmentsystem.model.lec10.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {
}
