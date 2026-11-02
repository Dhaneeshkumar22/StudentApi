package com.dhaneesh.welcome.controller;

import com.dhaneesh.welcome.model.Transport;
import com.dhaneesh.welcome.service.TravelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travel")
public class TravelController {

    private final TravelService travelService;

    private final Logger logger =
            LoggerFactory.getLogger(TravelController.class);

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping("/get")
    public List<Transport> getAllTravellers() {

        logger.info("Values fetched successfully");

        return travelService.getAllTransports();
    }

    @PostMapping("/add")
    public Transport addTransport(@RequestBody Transport transport) {

        logger.info("Transport added successfully");

        return travelService.saveTransport(transport);
    }
}