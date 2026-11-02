package com.dhaneesh.welcome.service;

import com.dhaneesh.welcome.model.Hostellers;
import com.dhaneesh.welcome.repository.HostellerRepo;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostellerService {

    private final HostellerRepo hs;

    public HostellerService(HostellerRepo hs) {
        this.hs = hs;
    }

    public ResponseEntity<List<Hostellers>> getall() {
        return ResponseEntity.ok(hs.findAll());
    }

    public ResponseEntity<String> add(Hostellers h)
    {
        if(hs.existsByName(h.getName()))
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Already exists");
        }
        else
        {
            hs.save(h);
            return ResponseEntity.ok().body("Saved");
        }
    }
    public ResponseEntity<Hostellers> getb(Integer id)
    {
        return ResponseEntity.ok().body(hs.findById(id).get());
    }
    public ResponseEntity<String> delete(Integer id)
    {
        if(hs.existsById(id)) {
            hs.deleteById(id);
            return ResponseEntity.ok().body("Deleted SuccesFully");
        }
        else {
            return null;
        }
    }
    public ResponseEntity<Hostellers> update(Integer id, Hostellers h)
    {
        if(hs.existsById(id))
        {
          Hostellers res=hs.findById(id).get();
          if(h.getName()!=null)
          {
              res.setName(h.getName());
          }
          if(h.getNumber()!=null)
          {
              res.setNumber(h.getNumber());
          }
          return ResponseEntity.ok().body(hs.save(res));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<Hostellers>> updatem(List<Hostellers> h)
    {
        return ResponseEntity.ok().body(hs.saveAll(h));
    }
}