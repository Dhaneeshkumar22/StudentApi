package com.dhaneesh.welcome.dao;

import com.dhaneesh.welcome.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {

    Student save(Student student);

    Optional<Student> findById(Long id);

    List<Student> findAll();

    List<Student> findByAgeGreaterThan(Integer age);

    List<Student> findByNameContainingIgnoreCase(String name);

    boolean existsByEmail(String email);

    void deleteById(Long id);

    List<Student> findAllUsingHql();
    List<Student> findbyage(Integer age);
}