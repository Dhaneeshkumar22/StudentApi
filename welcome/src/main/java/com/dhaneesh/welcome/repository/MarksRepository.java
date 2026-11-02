package com.dhaneesh.welcome.repository;

import com.dhaneesh.welcome.model.Marks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarksRepository extends JpaRepository<Marks,Integer> {
}
