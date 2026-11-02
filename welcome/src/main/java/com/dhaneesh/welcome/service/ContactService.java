package com.dhaneesh.welcome.service;

import com.dhaneesh.welcome.model.Contact;
import com.dhaneesh.welcome.repository.ContactRepo;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    public ContactRepo crepo;

    public ContactService (ContactRepo crepo)
    {
        this.crepo=crepo;
    }


    public ResponseEntity<Contact> get(String name)
    {
        Optional<Contact> c=crepo.findByName(name);
        if(c.isPresent())
        {
            return ResponseEntity.ok(c.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Contact> up(Integer id,Contact c)
    {
        if(crepo.existsById(id))
        {
            c.setId(id);
            return ResponseEntity.status(201).body(crepo.save(c));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Contact> addm(Contact c)
    {
        if(crepo.existsByName(c.getName())){

          //  Contact cs=crepo.findById(id);
            return ResponseEntity.notFound().build();
        }
        else {
         //   crepo.save(c);
            Contact cs=crepo.save(c);
            return ResponseEntity.status(HttpStatus.CREATED).body(cs);
        }
    }

    public ResponseEntity<String> delete(Integer id)
    {
        if(crepo.existsById(id))
        {
           crepo.deleteById(id);
            return ResponseEntity.ok("Deleted Succesfully");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
