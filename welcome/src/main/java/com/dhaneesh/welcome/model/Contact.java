package com.dhaneesh.welcome.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

@Entity
public class Contact {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    @NotNull
    String number;

    public Contact(){

    }
    public Contact(Integer id,String name,String number)
    {
        this.id=id;
        this.name=name;
        this.number=number;
    }
    public int getId()
    {
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
    public String getNumber()
    {
        return number;
    }
    public void setNumber(String number)
    {
        this.number=number;
    }

}
