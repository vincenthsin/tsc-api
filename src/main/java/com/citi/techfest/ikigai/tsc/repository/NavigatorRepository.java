package com.citi.techfest.ikigai.tsc.repository;
import com.citi.techfest.ikigai.tsc.entity.Navigator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NavigatorRepository extends JpaRepository<Navigator, Long> {
}
