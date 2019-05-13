package com.epam.multitenancy.demo.service;

import com.epam.multitenancy.demo.domain.Appointment;
import com.epam.multitenancy.demo.domain.Barber;
import com.epam.multitenancy.demo.repository.AppointmentRepository;
import com.epam.multitenancy.demo.repository.BarberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class BarbershopService {

    private final BarberRepository barberRepository;

    private final AppointmentRepository appointmentRepository;

    public List<Barber> getBarbers() {
        return barberRepository.findAll();
    }

    public List<LocalDateTime> getTimeSlots() {
        return IntStream.rangeClosed(10, 18)
                .mapToObj(hour -> LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(hour, 0)))
                .collect(Collectors.toList());
    }

    public Appointment book(Long barberId, LocalDateTime timeSlot, String clientName, String clientPhone) {
        Barber barber = barberRepository.findById(barberId).orElseThrow(EntityNotFoundException::new);
        Appointment appointment = Appointment.builder()
                .barber(barber)
                .dateTime(timeSlot)
                .clientName(clientName)
                .clientPhone(clientPhone)
                .build();
        return appointmentRepository.save(appointment);
    }
}
