package com.epam.multitenancy.demo.repository;

import com.epam.multitenancy.demo.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
