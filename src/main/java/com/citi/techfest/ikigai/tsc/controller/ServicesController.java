package com.citi.techfest.ikigai.tsc.controller;
import com.citi.techfest.ikigai.tsc.entity.Participant;
import com.citi.techfest.ikigai.tsc.entity.ServiceItem;
import com.citi.techfest.ikigai.tsc.entity.SocialService;
import com.citi.techfest.ikigai.tsc.repository.ParticipantRepository;
import com.citi.techfest.ikigai.tsc.repository.ServiceItemRepository;
import com.citi.techfest.ikigai.tsc.service.ParticipantService;
import com.citi.techfest.ikigai.tsc.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/service")
public class ServicesController {
    private final ServiceItemRepository serviceItemRepository;
    private final ParticipantRepository participantRepository;

    public ServicesController(ServiceItemRepository serviceItemRepository, ParticipantRepository participantRepository) {
        this.serviceItemRepository = serviceItemRepository;
        this.participantRepository = participantRepository;
    }

    @PostMapping("/addService")
    public ResponseEntity<ServiceItem> addService(@RequestBody ServiceItem serviceItem) {
        ServiceItem savedServiceItem = serviceItemRepository.save(serviceItem);
        return ResponseEntity.ok(savedServiceItem);
    }

    @PostMapping("/updateService")
    public ResponseEntity<ServiceItem> updateService(@RequestBody ServiceItem serviceItem) {
        ServiceItem savedServiceItem = serviceItemRepository.save(serviceItem);
        return ResponseEntity.ok(savedServiceItem);
    }

    @PostMapping("/addBeneficiary")
    public ResponseEntity<Participant> addBeneficiary(@RequestBody Participant beneficiary) {
        Participant savedBeneficiary = participantRepository.save(beneficiary);
        return ResponseEntity.ok(savedBeneficiary);
    }

    @PostMapping("/updateBeneficiary")
    public ResponseEntity<Participant> updateBeneficiary(@RequestBody Participant beneficiary) {
        Participant savedBeneficiary = participantRepository.save(beneficiary);
        return ResponseEntity.ok(savedBeneficiary);
    }
}
