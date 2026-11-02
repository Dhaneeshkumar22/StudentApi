package com.dhaneesh.welcome.repository;

import com.dhaneesh.welcome.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
