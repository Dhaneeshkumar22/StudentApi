package com.dhaneesh.welcome.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class Transport {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
  //  @NotNull
    private float distance;

    public Transport(){}

    public Transport(int id,String name,float distance)
    {
        this.id=id;
        this.name=name;
        this.distance=distance;
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
    public float getDistance()
    {
        return distance;
    }
    public void setDistance(float distance)
    {
        this.distance=distance;
    }
}
