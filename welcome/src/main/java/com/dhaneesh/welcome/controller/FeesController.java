package com.dhaneesh.welcome.controller;

import com.dhaneesh.welcome.model.Feess;
import com.dhaneesh.welcome.service.FeesService;
import jakarta.persistence.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ RestController
@RequestMapping("/fees")
public class FeesController {
    @Autowired
     FeesService f;
    Logger logger= LoggerFactory.getLogger(FeesController.class);
//    public FeesController(FeesService f)
//    {
//        this.f=f;
//    }

    @GetMapping("/get")
    public List<Feess> getfees(Feess fs)
    {try {
        logger.info("Values fetched Succesfully");
        return f.getFees();
    }
    catch(Exception e)
    {
        logger.error("Unable to get Values");
        return null;
    }
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id)
    {
        f.delfees(id);
    }

//    @PutMapping("/update/{id}")
//    public Fees update(@PathVariable int id, @RequestBody Fees fees)
//    {
//        return f.update(id,fees);
//    }

    @PostMapping("/insert")

    public Feess setF(@RequestBody Feess fees)
    {
        return f.setF(fees);
    }
}
