package com.dhaneesh.welcome.repository;

import com.dhaneesh.welcome.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRepo extends JpaRepository<Transport,Integer> {
}
