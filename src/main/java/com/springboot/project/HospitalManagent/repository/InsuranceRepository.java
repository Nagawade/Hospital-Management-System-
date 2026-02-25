package com.springboot.project.HospitalManagent.repository;

import com.springboot.project.HospitalManagent.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

}
