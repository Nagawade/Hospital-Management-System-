package com.springboot.project.HospitalManagent;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.springboot.project.HospitalManagent.dto.BloodGroupResponseEntity;
import com.springboot.project.HospitalManagent.entity.Patient;
import com.springboot.project.HospitalManagent.entity.type.BloodGroupType;
import com.springboot.project.HospitalManagent.repository.PatientRepository;
import com.springboot.project.HospitalManagent.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootTest
public class PatientTests {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientService patientService;

    @Test
    public void testpatientRepository(){
        //List<Patient> patient = patientRepository.findByName("Mauli Nagawade");
        //System.out.println(patient);

        //List<Patient> patientList = patientRepository.findByBloodGroup(BloodGroupType.O_Positive);
        //System.out.println(patientList);

        //List<Object []> bloodGroupList = patientRepository.countOfEachBloodGroup();

       // for(Object [] bloodGroup : bloodGroupList){
           // System.out.println(bloodGroup[0]+" "+bloodGroup[1]);
       // }


        List<BloodGroupResponseEntity> bloodGroupList = patientRepository.countEachBloodgroup();

         for(BloodGroupResponseEntity bloodGroupResponse : bloodGroupList){
            System.out.println(bloodGroupResponse);
         }

        Page<Patient> page = patientRepository.findAll(PageRequest.of(1, 2));

        for (Patient p : page.getContent()) {
            System.out.println(p);
        }


    }










}
