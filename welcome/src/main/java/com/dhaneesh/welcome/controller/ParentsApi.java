package com.dhaneesh.welcome.controller;

import com.dhaneesh.welcome.model.Parents;
import com.dhaneesh.welcome.service.ParentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parents")
public class ParentsApi {

    @Autowired
    ParentsService parentsService;

    @GetMapping("/get")
    public List<Parents> getName(Parents  p)
    {
        return parentsService.getAll();
    }


}
