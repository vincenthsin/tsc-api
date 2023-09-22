package com.citi.techfest.ikigai.tsc.repository;
import com.citi.techfest.ikigai.tsc.entity.Cabin;
import com.citi.techfest.ikigai.tsc.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CabinRepository extends JpaRepository<Cabin, Long> {
    List<Cabin> findByLocationAndFacility(String location, String facility);
}
