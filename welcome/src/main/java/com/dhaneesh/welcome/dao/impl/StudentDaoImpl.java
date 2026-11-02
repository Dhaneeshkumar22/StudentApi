package com.dhaneesh.welcome.dao.impl;

import com.dhaneesh.welcome.dao.StudentDao;
import com.dhaneesh.welcome.model.Student;
import com.dhaneesh.welcome.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentDaoImpl implements StudentDao {

    private final StudentRepository studentJpaRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(StudentRepository studentJpaRepository) {
        this.studentJpaRepository = studentJpaRepository;
    }

    @Override
    public Student save(Student student) {
        return studentJpaRepository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentJpaRepository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentJpaRepository.findAll();
    }

    @Override
    public List<Student> findByAgeGreaterThan(Integer age) {
        return studentJpaRepository.findByAgeGreaterThan(age);
    }

    @Override
    public List<Student> findByNameContainingIgnoreCase(String name) {
        return studentJpaRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public boolean existsByEmail(String email) {
        return studentJpaRepository.findAll().stream()
                .anyMatch(s -> s.getEmail().equalsIgnoreCase(email));
    }

    @Override
    public void deleteById(Long id) {
        studentJpaRepository.deleteById(id);
    }

    @Override
    public List<Student> findAllUsingHql() {

        String hql = "FROM Student s where s.+id>8";

        TypedQuery<Student> query =
                entityManager.createQuery(hql, Student.class);

        return query.getResultList();
    }

    @Override
    public List<Student> findbyage(Integer age)
    {
        String hql="From Student s where s.age> :age";
        return entityManager.createQuery(hql,Student.class)
                .setParameter("age", age)
                .getResultList();


    }

}