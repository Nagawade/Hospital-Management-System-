package com.springboot.project.HospitalManagent.service;

import com.springboot.project.HospitalManagent.dto.AppointmentResponseDto;
import com.springboot.project.HospitalManagent.dto.CreateAppointmentRequestDto;
import com.springboot.project.HospitalManagent.entity.Appointment;
import com.springboot.project.HospitalManagent.entity.Doctor;
import com.springboot.project.HospitalManagent.entity.Patient;
import com.springboot.project.HospitalManagent.repository.AppointmentRepository;
import com.springboot.project.HospitalManagent.repository.DoctorRepository;
import com.springboot.project.HospitalManagent.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public AppointmentResponseDto createAppointment(CreateAppointmentRequestDto createAppointmentRequestDto) {
        Long drId = createAppointmentRequestDto.getDoctorId();
        Long patientId = createAppointmentRequestDto.getPatientId();

        Patient patient = patientRepository.findById(patientId)
                                            .orElseThrow(()->new EntityNotFoundException("Patient Not Found with id: "+patientId));

        Doctor dctr = doctorRepository.findById(drId)
                                            .orElseThrow(()->new EntityNotFoundException("Doctor Not Found with id: "+drId));

        Appointment appointment = Appointment.builder()
                .reason(createAppointmentRequestDto.getReason())
                .appointmentTime(createAppointmentRequestDto.getAppointmentTime())
                .build();

        appointment.setPatient(patient);
        appointment.setDoctor(dctr);

        appointment = appointmentRepository.save(appointment);

    return modelMapper.map(appointment,AppointmentResponseDto.class);

    }

    public @Nullable List<AppointmentResponseDto> getAllAppointmentsOfDoctor(Long id) {

        List<Appointment> appointments = appointmentRepository.findByDoctorId(id);
        return appointments.stream()
                .map(a->modelMapper.map(a, AppointmentResponseDto.class))
                .toList();
    }
}
