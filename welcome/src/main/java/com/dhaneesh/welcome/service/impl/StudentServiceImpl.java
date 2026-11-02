package com.dhaneesh.welcome.service.impl;

import com.dhaneesh.welcome.dao.StudentDao;
import com.dhaneesh.welcome.dto.StudentRequest;
import com.dhaneesh.welcome.dto.StudentResponse;
import com.dhaneesh.welcome.exception.ResourceNotFoundException;
import com.dhaneesh.welcome.model.Student;
import com.dhaneesh.welcome.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    @Transactional
    public StudentResponse create(StudentRequest request) {

        if (studentDao.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists: " + request.getEmail());
        }

        if (request.getAge() != null && (request.getAge() < 5 || request.getAge() > 120)) {
            throw new RuntimeException("Invalid age: " + request.getAge());
        }

        Student student = new Student();
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setAge(request.getAge());
        student.setEnrolledOn(LocalDate.now());

        Student saved = studentDao.save(student);
        return mapToResponse(saved);
    }

    @Override
    public StudentResponse findById(Long id) {
        Student student = studentDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        return mapToResponse(student);
    }

    @Override
    public List<StudentResponse> findAll() {
        return studentDao.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentResponse> findAdults() {
        return studentDao.findByAgeGreaterThan(17).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentResponse> searchByName(String name) {
        return studentDao.findByNameContainingIgnoreCase(name).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!studentDao.findById(id).isPresent()) {
            throw new ResourceNotFoundException("Cannot delete — student not found: " + id);
        }
        studentDao.deleteById(id);
    }

    @Override
    public List<Student> findd(){
        return studentDao.findAllUsingHql();
    }

    @Override
    public List<Student> findbyage(Integer age)
    {
        return studentDao.findbyage(age);
    }

    private StudentResponse mapToResponse(Student student) {
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setEmail(student.getEmail());
        response.setAge(student.getAge());
        response.setEnrolledOn(student.getEnrolledOn());
        return response;
    }
}