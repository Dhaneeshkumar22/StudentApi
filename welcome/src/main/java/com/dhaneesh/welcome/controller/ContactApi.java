package com.dhaneesh.welcome.controller;

import com.dhaneesh.welcome.model.Contact;
import com.dhaneesh.welcome.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.sql.ast.tree.expression.Summarization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.beans.BeanProperty;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Tag(name = "contact",
description = "Api for mananging contacts")
@RestController
@RequestMapping("/contact")
public class ContactApi {

     ContactService cservice;

     public ContactApi(ContactService cservice)
     {
         this.cservice=cservice;
     }


        @Operation(summary = "Get Contact By id")
        @ApiResponses({
                @ApiResponse(
                        responseCode = "200",
                        description = "Contact found successfully"
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Contact not found"
                )
        })
     @GetMapping("/get/{name}")
    public ResponseEntity<Contact> getm(@PathVariable String name)
     {
         return cservice.get(name);
     }

    @PatchMapping("/patch/{id}")
    public ResponseEntity<Contact> update(@PathVariable Integer id,@RequestBody Contact c)
    {
        return cservice.up(id,c);
    }

    @PostMapping("/add")
    public ResponseEntity<Contact> add(@RequestBody Contact c)
    {
        return cservice.addm(c);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> del(@PathVariable Integer id)
    {
        return cservice.delete(id);


    }

}
