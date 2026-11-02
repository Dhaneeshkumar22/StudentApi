package com.dhaneesh.welcome.repository;

import com.dhaneesh.welcome.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Books,Integer> {
}
