package com.spring.boot.universitycoursemanagmentsystem.repo.lec9.repo;

import com.spring.boot.universitycoursemanagmentsystem.model.lec9.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmailRepo extends JpaRepository<Email, Long> {

    Optional<List<Email>> findByNameIn(List<String> names);




    Optional<List<Email>>findByName(String name);

    Optional <Email> findByContent(String content);
}
