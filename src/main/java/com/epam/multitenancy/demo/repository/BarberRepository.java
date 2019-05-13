package com.epam.multitenancy.demo.repository;

import com.epam.multitenancy.demo.domain.Barber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BarberRepository extends JpaRepository<Barber, Long> {

    List<Barber> findByTenantId(String tenantId);

}
