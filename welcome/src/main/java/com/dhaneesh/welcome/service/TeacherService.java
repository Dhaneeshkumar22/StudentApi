package com.dhaneesh.welcome.service;

import com.dhaneesh.welcome.model.Teacher;
import com.dhaneesh.welcome.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    public TeacherRepository trepo;

    public TeacherService(TeacherRepository trepo)
    {
        this.trepo=trepo;
    }

    public List<Teacher> getTeacher()
    {
        return trepo.findAll();
    }

    public Teacher addTeacher(Teacher t)
    {
        return trepo.save(t);
    }

    public Teacher getid(int id)
    {
        return trepo.findById(id).orElse(null);
    }

    public List<Teacher> addmany(List<Teacher> t)
    {
        return trepo.saveAll(t);
    }

}
