package com.dhaneesh.welcome.repository;

import com.dhaneesh.welcome.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepo extends JpaRepository<Contact,Integer> {
    boolean existsByName(String name);
    boolean existsByNumber(String number);
    Optional<Contact> findByName(String name);
}
