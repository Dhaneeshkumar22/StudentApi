package com.dhaneesh.welcome.service;

import com.dhaneesh.welcome.model.Marks;
import com.dhaneesh.welcome.repository.MarksRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service

public class MarksService {


    private final MarksRepository m;

    public MarksService(MarksRepository m)
    {
        this.m=m;
    }

    public List<Marks> getAll(){
        return m.findAll();
    }

    public Marks setmarks(Marks marks)
    {
        return m.save(marks);
    }

}
