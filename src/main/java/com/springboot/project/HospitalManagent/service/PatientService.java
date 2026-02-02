package com.springboot.project.HospitalManagent.service;

import com.springboot.project.HospitalManagent.entity.Patient;
import com.springboot.project.HospitalManagent.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    @Transactional
    public Patient getPatientById(Long id) {
        Patient p1 = patientRepository.findById(id).orElseThrow();

        Patient p2 = patientRepository.findById(id).orElseThrow();
        return p1;
    }



}
