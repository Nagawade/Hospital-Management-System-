package com.springboot.project.HospitalManagent.controller;

import com.springboot.project.HospitalManagent.service.DoctorService;
import com.springboot.project.HospitalManagent.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final PatientService patientService;
    private final DoctorService doctorServise;
}
