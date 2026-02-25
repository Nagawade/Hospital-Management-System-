package com.springboot.project.HospitalManagent.repository;

import com.springboot.project.HospitalManagent.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    boolean existsByUserId(Long id);
    Optional<Doctor> findByUserUsername(String username);

}
