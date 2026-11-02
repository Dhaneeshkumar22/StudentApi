package com.dhaneesh.welcome.model;

import jakarta.persistence.*;

@Entity
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int mark;

    private String groupName;

    public Marks() {
    }

    public Marks(int mark, String groupName) {
        this.mark = mark;
        this.groupName = groupName;
    }

    public Integer getId() {
        return id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}