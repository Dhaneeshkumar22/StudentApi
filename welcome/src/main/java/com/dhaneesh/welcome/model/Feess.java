package com.dhaneesh.welcome.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Feess {
    @Id
            @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;
    long fees;

    public Feess() {
    }

    public Feess(Integer id, long fees) {
        this.id = id;
        this.fees = fees;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getFees() {
        return fees;
    }

    public void setFees(long fees){
        this.fees=fees;
    }

}

