package com.dhaneesh.welcome.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Projects {
    @Id
    private Integer id;
    private String name;
    private String title;

    public Projects(){}

    public Projects(Integer id,String name,String title)
    {
        this.id=id;
        this.name=name;
        this.title=title;
    }

    public void setId(Integer id)
    {
        this.id=id;
    }

    public int getId()
    {
        return id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title=title;
    }
}
