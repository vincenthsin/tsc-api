package com.citi.techfest.ikigai.tsc.controller;

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

    @PostMapping("/searchCabin")
    public ResponseEntity<String> searchCabin(@RequestBody Cabin cabinSearchCondition) {
        // TODO: Implement cabin search logic based on the cabinSearchCondition
//        List<Cabin> cabins = cabinRepository.findAll();
//        return ResponseEntity.ok(cabinData);
    }
}
