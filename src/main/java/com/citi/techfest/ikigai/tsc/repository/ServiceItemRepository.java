package com.citi.techfest.ikigai.tsc.repository;
import com.citi.techfest.ikigai.tsc.entity.ServiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceItemRepository extends JpaRepository<ServiceItem, Long> {
}
