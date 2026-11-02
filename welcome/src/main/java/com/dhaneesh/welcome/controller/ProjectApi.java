package com.dhaneesh.welcome.controller;

import com.dhaneesh.welcome.model.Projects;
import com.dhaneesh.welcome.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Tag()
@RestController
@RequestMapping("/projects")
public class ProjectApi {

    public ProjectService p;

    public ProjectApi(ProjectService p)
    {
        this.p=p;
    }

@Operation(summary = "Get all datas from here")

@GetMapping("/get")
public ResponseEntity<List<Projects>> geta()
{
    return p.geta();
}

@PostMapping("/post")
    public ResponseEntity<Projects> add(@RequestBody Projects op)
{
    return p.add(op);
}

@Operation(summary = "Here You can delete Project through their Unique id")
@DeleteMapping("/del/{id}")
    public ResponseEntity<String> del(@PathVariable Integer id)
{
    return p.delete(id);
}

@Operation(summary = "here You can update details through their id")
    @PutMapping("/put/{id}")
    public ResponseEntity<Projects> update(@PathVariable Integer id, @RequestBody Projects op)
{
    return p.update(id,op);
}

@Operation(summary = "You can update any field")
    @PatchMapping("/put/{id}")
    public ResponseEntity<Projects> part(@PathVariable Integer id,@RequestBody Projects op)
{
    return p.part(id,op);
}

}
