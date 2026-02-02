package com.springboot.project.HospitalManagent;

import com.springboot.project.HospitalManagent.entity.Insurance;
import com.springboot.project.HospitalManagent.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;

@SpringBootTest
@Rollback
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testInsurance() {
        Insurance insurance = Insurance.builder().policyNumber("HDFC_10")
                                                .provider("HDFC")
                .validUntil(LocalDate.of(2026,04,01)).build();


        insuranceService.assignInsurenceToPatient(insurance,1L);

        insuranceService.disassociateInsuranceOfPatient(insurance.getId());

    }
}
