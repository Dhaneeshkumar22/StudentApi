package com.dhaneesh.welcome.controller;

import com.dhaneesh.welcome.model.Teacher;
import com.dhaneesh.welcome.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Teacher")
public class TeacherController {
    public TeacherService tservice;
    public final Logger logger= LoggerFactory.getLogger(TeacherController.class);
    public TeacherController(TeacherService tservice){
        this.tservice=tservice;
    }
    @GetMapping("/get")
    public List<Teacher> getTeacher(Teacher t)
    {
        return tservice.getTeacher();
    }

    @PostMapping("/add")
    public Teacher addTeacher(@RequestBody Teacher t)
    {
        return tservice.addTeacher(t);
    }

    @GetMapping("/get/{id}")
    public Teacher getbyid(@PathVariable Integer id)
    {try {
        logger.info("Values fetche");
        return tservice.getid(id);
    }
    catch(Exception e)
    {
        logger.info("No data found");
        return null;
    }
    }

    @PostMapping("/many")
    public List<Teacher> update(@RequestBody List<Teacher> t)
    {
        return tservice.addmany(t);
    }

}
