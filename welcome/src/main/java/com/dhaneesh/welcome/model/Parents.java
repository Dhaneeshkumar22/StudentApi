package com.dhaneesh.welcome.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Parents {
    @Id
    Integer id;
    String name;

    public Parents(){

    }
    public Parents(Integer id, String name)
    {
        this.id=id;
        this.name=name;
    }
    public int getid(){
        return id;
    }
    public void setId(Integer id)
    {
        this.id=id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
}
