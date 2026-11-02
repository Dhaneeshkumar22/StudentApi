package com.dhaneesh.welcome.repository;

import com.dhaneesh.welcome.model.Parents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentsRepo extends JpaRepository<Parents,Integer> {
    boolean existsByName(String name);
}
