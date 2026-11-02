package com.dhaneesh.welcome.repository;

import com.dhaneesh.welcome.model.Hostellers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostellerRepo extends JpaRepository<Hostellers,Integer> {
    boolean existsByName(String name);
}
