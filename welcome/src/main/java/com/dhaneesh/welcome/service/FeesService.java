package com.dhaneesh.welcome.service;

import com.dhaneesh.welcome.model.Feess;
import com.dhaneesh.welcome.repository.FeesRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeesService {

    FeesRepo f;

    public FeesService(FeesRepo f)
    {
        this.f=f;
    }
    public List<Feess> getFees()
    {
        return f.findAll();
    }

    public Feess setF(Feess fees)
    {
        return f.save(fees);
    }

    public void delfees(int id)
    {
        f.deleteById(id);
    }
    public Feess update(int id,Feess nfees)
    {
        Feess old=f.findById(id).orElseThrow(()-> new RuntimeException("No fees available"));
     //   return f.findById(id);

        return null;

    }

}
