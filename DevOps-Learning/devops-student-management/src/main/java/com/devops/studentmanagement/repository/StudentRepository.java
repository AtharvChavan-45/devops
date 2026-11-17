package com.devops.studentmanagement.repository;

import com.devops.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Custom finder method to check if an email already exists
    Optional<Student> findByEmail(String email);

    boolean existsByEmail(String email);
}
