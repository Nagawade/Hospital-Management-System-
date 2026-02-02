package com.springboot.project.HospitalManagent.repository;

import com.springboot.project.HospitalManagent.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Appointment,Long> {

}
