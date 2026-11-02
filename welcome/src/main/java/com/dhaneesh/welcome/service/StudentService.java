package com.dhaneesh.welcome.service;

import com.dhaneesh.welcome.model.Student;
import com.dhaneesh.welcome.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//
//
//@Service
//public class StudentService {
//
//    private final StudentRepository repository;
//
//    public StudentService(StudentRepository repository) {
//        this.repository = repository;
//    }
//
//    public List<Student> getAllStudent(){
//        return repository.findAll();
//    }
//
//    public Student getStudentById(Integer id) {
//        return repository.findById(id).orElse(null);
//    }
//
//    public String saveStudent(Student student) {
//        if(repository.existsByName(student.getName()))
//        {
//            return "Name Already exists";
//        }
//        else {
//            repository.save(student);
//            return "Inserted";
//        }
//    }
//    public List<Student> saveAllStudent(List<Student> student)
//    {
//        return repository.saveAll(student);
//    }
//    public void delete(Integer id)
//    {
//        repository.deleteById(id);
//    }
//}




//package com.dhaneesh.welcome.service;

import com.dhaneesh.welcome.dto.StudentRequest;
import com.dhaneesh.welcome.dto.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse create(StudentRequest request);

    StudentResponse findById(Long id);

    List<StudentResponse> findAll();

    List<StudentResponse> findAdults();

    List<StudentResponse> searchByName(String name);

    void delete(Long id);
    List<Student> findd();
    List<Student> findbyage(Integer age);
}