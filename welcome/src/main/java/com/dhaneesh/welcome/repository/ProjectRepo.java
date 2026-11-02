package com.dhaneesh.welcome.repository;

import com.dhaneesh.welcome.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Projects,Integer>{

    boolean existsById(Integer id);
}
