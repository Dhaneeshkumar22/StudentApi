package com.dhaneesh.welcome.service;

import com.dhaneesh.welcome.model.Parents;
import com.dhaneesh.welcome.repository.ParentsRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParentsService {

    private final ParentsRepo p;

    public ParentsService(ParentsRepo p) {
        this.p = p;
    }

    public List<Parents> getAll() {
        return p.findAll();
    }

    public Parents add(Parents op) {

        if (p.existsByName(op.getName())) {
            throw new RuntimeException("Parent already exists");
        }

        return p.save(op);
    }

}
