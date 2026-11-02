package com.dhaneesh.welcome.service;

import com.dhaneesh.welcome.model.Projects;
import com.dhaneesh.welcome.repository.ProjectRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    public ProjectRepo p;

    public ProjectService(ProjectRepo p)
    {
        this.p=p;
    }

    public ResponseEntity<List<Projects>> geta()
    {
        return ResponseEntity.ok(p.findAll());
    }

    public ResponseEntity<Projects> add(Projects op)
    {
        if(p.existsById(op.getId())){
            return ResponseEntity.notFound().build();
        }
        else {
           // p.save(op);
            return ResponseEntity.ok(p.save(op));

        }
    }

    public ResponseEntity<String> delete(Integer id) {
        if (p.existsById(id)) {
            p.deleteById(id);
            return ResponseEntity.ok().body("Deleted");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not done");
        }
    }

    public ResponseEntity<Projects> update(Integer id,Projects op)
    {
        if(p.existsById(id))
        {
            op.setId(id);
            return ResponseEntity.ok().body(p.save(op));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Projects> part(Integer id,Projects op)
    {
        if(!p.existsById(id))
        {
            return ResponseEntity.notFound().build();
        }
        Projects res=p.findById(id).get();
        if(op.getName()!=null)
        {
            res.setName(op.getName());
        }
        if(op.getTitle()!=null)
        {
            res.setTitle(op.getTitle());
        }
        return ResponseEntity.ok().body(p.save(res));
    }

}
