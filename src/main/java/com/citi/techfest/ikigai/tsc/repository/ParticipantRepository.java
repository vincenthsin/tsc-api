package com.citi.techfest.ikigai.tsc.repository;

import com.citi.techfest.ikigai.tsc.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    List<Participant> findByName(String name);

    List<Participant> findByAssignedNavigator(String assignedNavigatorID);

    List<Participant> findByRole(String role);

    List<Participant> findAll();
}
