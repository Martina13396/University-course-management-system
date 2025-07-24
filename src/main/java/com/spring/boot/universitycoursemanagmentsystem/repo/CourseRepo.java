package com.spring.boot.universitycoursemanagmentsystem.repo;

import com.spring.boot.universitycoursemanagmentsystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
}
