package com.spring.boot.universitycoursemanagmentsystem.repo;

import com.spring.boot.universitycoursemanagmentsystem.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor, Long> {

}
