package com.citi.techfest.ikigai.tsc.repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.citi.techfest.ikigai.tsc.entity.Foo;
import com.citi.techfest.ikigai.tsc.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    List<Participant> findByName(String name);

    List<Participant> findByAssignedNavigator(String assignedNavigatorID);

    List<Participant> findByOrganizationNameAndServiceName(String orgName, String serviceName);
    List<Participant> findByRole(String role);

    List<Participant> findAll();
}
