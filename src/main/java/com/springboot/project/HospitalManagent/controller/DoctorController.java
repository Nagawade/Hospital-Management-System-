package com.springboot.project.HospitalManagent.controller;

import com.springboot.project.HospitalManagent.dto.AppointmentResponseDto;
import com.springboot.project.HospitalManagent.entity.Appointment;
import com.springboot.project.HospitalManagent.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import com.springboot.project.HospitalManagent.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class DoctorController {

    private final AppointmentService appointmentService;

    @GetMapping("/doctor/appointments")
    public ResponseEntity<List<AppointmentResponseDto>> getAllAppointmentsOfDoctor(
            Authentication authentication
    ) {
        String username = authentication.getName(); // ✅ from JWT
        return ResponseEntity.ok(
                appointmentService.getAllAppointmentsOfDoctor(username)
        );
    }
}
