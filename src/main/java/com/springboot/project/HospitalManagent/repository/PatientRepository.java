package com.springboot.project.HospitalManagent.repository;

import com.springboot.project.HospitalManagent.dto.BloodGroupResponseEntity;
import com.springboot.project.HospitalManagent.entity.Patient;
import com.springboot.project.HospitalManagent.entity.type.BloodGroupType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {


    List<Patient> findByName(String name);

    @Query("select p from Patient p where BloodGroup= ?1")
    List<Patient> findByBloodGroup(BloodGroupType BloodGroup);

    @Query("SELECT new com.springboot.project.HospitalManagent.dto.BloodGroupResponseEntity (p.BloodGroup , COUNT(p)) from Patient p GROUP BY p.BloodGroup")
    //List<Object []> countOfEachBloodGroup();
    List<BloodGroupResponseEntity> countEachBloodgroup();  // PROJECTION in JPQL


    // PAGINATION IN JPQL

    @Query(value = "select * from patient",nativeQuery = true)
    Page<Patient> findByNativeQuery(@Param("pageable") Pageable pageable);




}
