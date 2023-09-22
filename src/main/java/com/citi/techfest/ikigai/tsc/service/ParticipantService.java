package com.citi.techfest.ikigai.tsc.service;

import com.citi.techfest.ikigai.tsc.dto.BeneficiarySearchCondition;
import com.citi.techfest.ikigai.tsc.dto.StaffSearchCondition;
import com.citi.techfest.ikigai.tsc.entity.Navigator;
import com.citi.techfest.ikigai.tsc.entity.Participant;
import com.citi.techfest.ikigai.tsc.entity.ServiceItem;
import com.citi.techfest.ikigai.tsc.mapper.ParticipantMapper;
import com.citi.techfest.ikigai.tsc.repository.NavigatorRepository;
import com.citi.techfest.ikigai.tsc.repository.ParticipantRepository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.citi.techfest.ikigai.tsc.util.Constants;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.*;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private NavigatorRepository navigatorRepository;


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

    @Autowired
    private ParticipantMapper participantMapper;

    public PageInfo<Participant> searchBeneficiary(BeneficiarySearchCondition beneficiarySearchCondition) {

        Boolean caseClosure = beneficiarySearchCondition.getCaseClosure();
        String developGoal = beneficiarySearchCondition.getDevelopGoal();
        String gender = beneficiarySearchCondition.getGender();
        String navigator = beneficiarySearchCondition.getNavigator();
        String name = beneficiarySearchCondition.getName();
        String services = beneficiarySearchCondition.getServices();
        int pageIndex = beneficiarySearchCondition.getPage(); //当前页码（注意：第一页是从0开始）
        int pageSize = beneficiarySearchCondition.getPaginationSize();
        String sortField = StringUtils.hasText(beneficiarySearchCondition.getOrderFiled()) ? beneficiarySearchCondition.getOrderFiled() : "name";
        String sortOrder = StringUtils.hasText(beneficiarySearchCondition.getOrderType()) ? beneficiarySearchCondition.getOrderType() : "ASC";
        PageHelper.startPage(pageIndex, pageSize);
        List<Participant> searchResult = participantMapper.searchBeneficiary(caseClosure, developGoal, gender, navigator, name, sortField, sortOrder, services);
        PageInfo<Participant> pageResult = new PageInfo<>(searchResult);
        return pageResult;
    }

    public PageInfo<Participant> searchStaff(StaffSearchCondition staffSearchCondition) {

        Integer page = staffSearchCondition.getPage();
        Integer paginationSize = staffSearchCondition.getPaginationSize();
        String sortField = StringUtils.hasText(staffSearchCondition.getOrderFiled()) ? staffSearchCondition.getOrderFiled() : "name";
        String sortOrder = StringUtils.hasText(staffSearchCondition.getOrderType()) ? staffSearchCondition.getOrderType() : "ASC";
        String organization = staffSearchCondition.getOrganization();
        LocalDate onboardDateFrom = staffSearchCondition.getOnboardDateFrom();
        LocalDate onboardDateTo = staffSearchCondition.getOnboardDateTo();
        String name = staffSearchCondition.getName();
        String gender = staffSearchCondition.getGender();
        PageHelper.startPage(page, paginationSize);
        List<Participant> searchResult = participantMapper.searchStaff(sortField, sortOrder, organization, onboardDateFrom, onboardDateTo, name, gender);
        return new PageInfo<>(searchResult);
    }
}