package com.springboot.project.HospitalManagent.controller;


import com.springboot.project.HospitalManagent.dto.AppointmentResponseDto;
import com.springboot.project.HospitalManagent.dto.CreateAppointmentRequestDto;
import com.springboot.project.HospitalManagent.entity.Patient;
import com.springboot.project.HospitalManagent.service.AppointmentService;
import com.springboot.project.HospitalManagent.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;
    private final AppointmentService appointmentService;

    @GetMapping("/{Id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {

        return ResponseEntity.ok(patientService.getPatientById(id));
    }

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
