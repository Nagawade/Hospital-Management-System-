package com.springboot.project.HospitalManagent;

import com.springboot.project.HospitalManagent.entity.Insurance;
import com.springboot.project.HospitalManagent.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
@Transactional
@Rollback
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testInsurance() {
        String uniquePolicyNumber = "HDFC_" + UUID.randomUUID().toString().substring(0, 8);
        Insurance insurance = Insurance.builder().policyNumber(uniquePolicyNumber)
                .provider("HDFC")
                .validUntil(LocalDate.of(2026, 04, 01)).build();

        insuranceService.assignInsurenceToPatient(insurance, 1L);

        insuranceService.disassociateInsuranceOfPatient(1L);

    }
}
