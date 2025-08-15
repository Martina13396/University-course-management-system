package com.spring.boot.universitycoursemanagmentsystem.repo.lec11.repo;

import com.spring.boot.universitycoursemanagmentsystem.model.lec11.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
}
