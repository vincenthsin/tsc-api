package com.citi.techfest.ikigai.tsc.controller;

import com.citi.techfest.ikigai.tsc.dto.CabinSearchCondition;
import com.citi.techfest.ikigai.tsc.entity.Cabin;
import com.citi.techfest.ikigai.tsc.repository.CabinRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cabin")
public class CabinController {
    private final CabinRepository cabinRepository;

    public CabinController(CabinRepository cabinRepository) {
        this.cabinRepository = cabinRepository;
    }

    @PostMapping("/getCabins")
    public ResponseEntity<List<Cabin>> getCabins() {
        List<Cabin> cabins = cabinRepository.findAll();
        return ResponseEntity.ok(cabins);
    }

    @PostMapping("/searchCabin")
    public ResponseEntity<List<Cabin>> searchCabin(@RequestBody Cabin cabinSearchCondition) {

        String location = cabinSearchCondition.getLocation();
        String facility = cabinSearchCondition.getFacility();
        List<Cabin> cabins = cabinRepository.findByLocationAndFacility(location, facility);
        return ResponseEntity.ok(cabins);
    }

}
