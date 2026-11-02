package com.dhaneesh.welcome.repository;

import com.dhaneesh.welcome.model.Feess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeesRepo extends JpaRepository<Feess,Integer> {
}
