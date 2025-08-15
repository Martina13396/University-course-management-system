package com.spring.boot.universitycoursemanagmentsystem.repo.lec11.repo;

import com.spring.boot.universitycoursemanagmentsystem.model.lec11.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {


    Optional<User> findByName(String name);
}
