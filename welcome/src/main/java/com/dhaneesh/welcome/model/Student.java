package com.dhaneesh.welcome.model;

import jakarta.persistence.*;

import jakarta.persistence.*;import java.time.LocalDate;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "email", length = 100, unique = true, nullable = false)
    private String email;

    @Column(name = "age")
    private Integer age;

    @Column(name = "enrolled_on")
    private LocalDate enrolledOn;

    // Constructors
    public Student() {}

    public Student(String name, String email, Integer age, LocalDate enrolledOn) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.enrolledOn = enrolledOn;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public LocalDate getEnrolledOn() { return enrolledOn; }
    public void setEnrolledOn(LocalDate enrolledOn) { this.enrolledOn = enrolledOn; }
}