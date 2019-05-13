package com.epam.multitenancy.demo.controller;

import com.epam.multitenancy.demo.domain.Appointment;
import com.epam.multitenancy.demo.service.BarbershopService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;

@Controller
@RequestMapping("/barbershop")
@RequiredArgsConstructor
public class BarbershopController {

    private final BarbershopService barbershopService;

    @GetMapping
    public ModelAndView barbershop() {
        ModelAndView mav = new ModelAndView("barbershop");
        mav.addObject("barbers", barbershopService.getBarbers());
        mav.addObject("timeSlots", barbershopService.getTimeSlots());
        return mav;
    }

    @PostMapping(consumes = APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView book(@RequestParam("barberId") Long barberId,
                             @RequestParam("timeSlot")
                             @DateTimeFormat(iso = DATE_TIME) LocalDateTime timeSlot,
                             @RequestParam("clientName") String clientName,
                             @RequestParam("clientPhone") String clientPhone) {
        Appointment appointment = barbershopService.book(barberId, timeSlot, clientName, clientPhone);
        ModelAndView mav = new ModelAndView("appointment");
        mav.addObject("appointment", appointment);
        return mav;
    }
}
