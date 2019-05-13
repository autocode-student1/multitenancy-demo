package com.epam.multitenancy.demo.repository;

import com.epam.multitenancy.demo.domain.Barber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberRepository extends JpaRepository<Barber, Long> {

}
