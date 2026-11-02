package com.dhaneesh.welcome.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Hostellers {

    @Id

    private Integer id;
    private  String name;
    private String number;

    public Hostellers(){}

    public Hostellers(Integer id,String name,String number)
    {
        this.number=number;
        this.id=id;
        this.name=name;
    }


    public int getId(){
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
    public String getNumber(){
        return number;
    }
    public void setNumber(String number)
    {
        this.number=number;
    }




}
