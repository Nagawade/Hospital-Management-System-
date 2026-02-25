package com.springboot.project.HospitalManagent.service;

import com.springboot.project.HospitalManagent.entity.Insurance;
import com.springboot.project.HospitalManagent.entity.Patient;
import com.springboot.project.HospitalManagent.repository.InsuranceRepository;
import com.springboot.project.HospitalManagent.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsurenceToPatient(Insurance insurance, Long patientId) {

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient is not present with id: " + patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient);

        return patient;
    }

    @Transactional
    public void disassociateInsuranceOfPatient(Long patientId) {

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient is not present with id: " + patientId));

        patient.setInsurance(null);

    }

}
