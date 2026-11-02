package com.dhaneesh.welcome.service;

import com.dhaneesh.welcome.model.Transport;
import com.dhaneesh.welcome.repository.TravelRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelService {

    private final TravelRepo travel;

    public TravelService(TravelRepo travel) {
        this.travel = travel;
    }

    public List<Transport> getAllTransports() {
        return travel.findAll();
    }

    public Transport saveTransport(Transport t) {
        return travel.save(t);
    }
}