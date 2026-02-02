package com.springboot.project.HospitalManagent.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class OnboardDoctorRequestDto {
    private Long userId;
    private String specialization;
    private String name;



}
