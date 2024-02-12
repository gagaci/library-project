package com.company.repository;

import com.company.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    boolean existsByFirstNameAndLastNameAndBirthDate(String firstName, String lastName, LocalDate birthdate);

    List<Author> findByFirstNameOrLastNameContaining(String firstName, String lastName);

    List<Author> findByBirthDate(LocalDate localDate);
    List<Author> findByDeathDate(String deathDate);
}
