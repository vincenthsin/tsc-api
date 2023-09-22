package com.citi.techfest.ikigai.tsc.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.citi.techfest.ikigai.tsc.entity.Navigator;
import com.citi.techfest.ikigai.tsc.entity.Participant;
import com.citi.techfest.ikigai.tsc.entity.ServiceItem;
import com.citi.techfest.ikigai.tsc.repository.NavigatorRepository;
import com.citi.techfest.ikigai.tsc.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.citi.techfest.ikigai.tsc.util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private NavigatorRepository navigatorRepository;

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public List<Navigator> getAllNavigators() {
        return navigatorRepository.findAll();
    }

    public List<Participant> getAllCaseWorkers() {
        return participantRepository.findByRole(Constants.CASEWORKER);
    }

    public List<Participant> getAllBeneficiaries() {
        return participantRepository.findByRole(Constants.BENEFICIARY);
    }
    public Optional<Participant> getParticipantById(String id) {
        return participantRepository.findById(Long.parseLong(id));
    }

    public List<Participant> getBeneficiariesByNavigatorID(String navigatorID) {
        return participantRepository.findByAssignedNavigator(navigatorID);
    }

    public List<Participant> getBeneficiariesByCaseWorkerID(String cid) {
//        Optional<Participant> caseWorker = participantRepository.findById(cid);
//        if(caseWorker.isPresent()){
//            return participantRepository.findByOrganizationNameAndServiceName(orgName, serviceName);
//        }
//        else return null;
        return null;
    }
    public Participant createParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    public Participant updateParticipant(String id, Participant participant) {
        Optional<Participant> optionalParticipant = participantRepository.findById(Long.parseLong(id));
        if (optionalParticipant.isPresent()) {
            participant.setId(Long.parseLong(id));
            return participantRepository.save(participant);
        }
        return null;
    }

    public void deleteParticipant(String id) {
        participantRepository.deleteById(Long.parseLong(id));
    }

    //---------------
    public List<Participant> getAssignedParticipants(String navigatorId) {
        List<Participant> plist = participantRepository.findByAssignedNavigator(navigatorId);
        return plist;
    }

    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    public List<ServiceItem> getAssignedParticipantsServices(String navigatorId) {
        List<Participant> assignedParticipants = getAssignedParticipants(navigatorId);
        List<ServiceItem> services = new ArrayList<>();
        for (Participant participant : assignedParticipants) {
            services.addAll(participant.getServiceItemList());
        }
        return services;
    }

    public void assignParticipantToNavigator(String navigatorId, Participant participant) {
        participant.setAssignedNavigator(navigatorId);
        participantRepository.save(participant);
        Navigator navigator = navigatorRepository.findById(Long.parseLong(navigatorId)).get();
        navigatorRepository.save(navigator);
    }
}