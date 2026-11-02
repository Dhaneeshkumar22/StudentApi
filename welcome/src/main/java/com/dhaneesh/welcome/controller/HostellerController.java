package com.dhaneesh.welcome.controller;

import com.dhaneesh.welcome.model.Contact;
import com.dhaneesh.welcome.model.Hostellers;
import com.dhaneesh.welcome.service.HostellerService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Hostel")
public class HostellerController {

    public HostellerService hs;

    public HostellerController(HostellerService hs)
    {
        this.hs=hs;
    }
    @GetMapping("/get")
    public ResponseEntity<List<Hostellers> >getall()
    {
        return hs.getall();
    }

    @Operation(
            summary = "this is a post part",
            description = "Welcome"
    )

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Hostellers h)
    {
        return hs.add(h);
    }

    @GetMapping("/getbyid/{id}")

    public ResponseEntity<Hostellers> getb(@PathVariable Integer id)
    {
        return hs.getb(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id)
    {
        return hs.delete(id);
    }

    @PatchMapping("/patch/{id}")
    public ResponseEntity<Hostellers> update(@PathVariable Integer id, @RequestBody Hostellers s)
    {
        return hs.update(id,s);
    }

    @PostMapping("/add many/")
    public ResponseEntity<List<Hostellers>> updatem(@RequestBody List<Hostellers> h)
    {
        return hs.updatem(h);
    }


}
