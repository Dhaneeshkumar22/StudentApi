package com.dhaneesh.welcome.controller;


import com.dhaneesh.welcome.model.Marks;
import com.dhaneesh.welcome.service.MarksService;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class MarksController {


    private final MarksService sa;

    public MarksController (MarksService sa)
    {
        this.sa=sa;
    }

    @GetMapping("/getmarks")
    public List<Marks> getAll(Marks s)
    {
        return sa.getAll();
    }

    @PostMapping("/addmarks")
    public Marks setmarks(@RequestBody Marks m)
    {
        return sa.setmarks(m);
    }

}
