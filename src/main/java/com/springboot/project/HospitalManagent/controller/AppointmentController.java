package com.springboot.project.HospitalManagent.controller;

import com.springboot.project.HospitalManagent.dto.AppointmentResponseDto;
import com.springboot.project.HospitalManagent.dto.CreateAppointmentRequestDto;
import com.springboot.project.HospitalManagent.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    @Autowired
    private final AppointmentService appointmentService;


    @PostMapping
    public ResponseEntity<AppointmentResponseDto> createNewAppointment(
            @RequestBody CreateAppointmentRequestDto requestDto) {

        AppointmentResponseDto response =
                appointmentService.createAppointment(requestDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

}
