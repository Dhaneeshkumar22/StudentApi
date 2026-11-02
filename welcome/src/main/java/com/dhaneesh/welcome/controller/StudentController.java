//package com.dhaneesh.welcome.controller;
//
//import com.dhaneesh.welcome.model.Student;
//import com.dhaneesh.welcome.service.StudentService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/students")
//public class StudentController {
//
//    private static final Logger logger =
//            LoggerFactory.getLogger(StudentController.class);
//
//    private final StudentService studentService;
//
//    // Constructor Injection
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }
//
//    //@GetMapping("/getdata/{id}")
//
//    @GetMapping
//    public List<Student> getAllStudent(Student s) {
//        return studentService.getAllStudent();
//    }
//
//    @GetMapping("/{id}")
//    public Student getStudentById(@PathVariable Integer id) {
//
//        try {
//            logger.info("Fetching student with ID: {}", id);
//
//            return studentService.getStudentById(id);
//
//        } catch (Exception e) {
//
//            logger.error("Error occurred while fetching student", e);
//
//            return null;
//        }
//    }
//
//    @PostMapping
//    public String createStudent(@RequestBody Student student) {
//        try {
//            logger.info("Creating student: {}", student.getName());
//
//            return studentService.saveStudent(student);
//        } catch (Exception e) {
//            logger.error("Error occured", e);
//            return null;
//        }
//    }
//
//    @PostMapping("/bulk")
//    public List<Student> saveAllStudent(@RequestBody List<Student> student) {
//        try {
//            logger.info("Datas are created succesfully {}", student.size());
//            return studentService.saveAllStudent(student);
//        } catch (Exception e) {
//            logger.error("Error while insert multiple datas: {}", e);
//            return null;
//        }
//    }
//
//    @DeleteMapping("/delete/{id}")
//
//    public void delete(@PathVariable Integer id)
//    {
//        try{
//            logger.info("Id deleted successfully {}: ",id);
//             studentService.delete(id);
//        }
//        catch(Exception e)
//        {
//            logger.error("Error while deleting",e);
//
//        }
//    }
//}


//package com.yourapp.controller;
//
//import com.we.dto.StudentRequest;
//import com.yourapp.dto.StudentResponse;
//import com.yourapp.service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
package com.dhaneesh.welcome.controller;

import com.dhaneesh.welcome.dto.StudentRequest;
import com.dhaneesh.welcome.dto.StudentResponse;
import com.dhaneesh.welcome.model.Student;
import com.dhaneesh.welcome.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentRequest request) {
        StudentResponse created = studentService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/adults")
    public ResponseEntity<List<StudentResponse>> findAdults() {
        return ResponseEntity.ok(studentService.findAdults());
    }

    @GetMapping("/search")
    public ResponseEntity<List<StudentResponse>> search(@RequestParam String name) {
        return ResponseEntity.ok(studentService.searchByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getthrough hql")

    public List<Student> findbyhql()
    {
        return studentService.findd();
    }


    @PostMapping("/getbyage/{age}")
    public List<Student> findbyage(@RequestBody Integer age)
    {
        return studentService.findbyage(age);
    }
}