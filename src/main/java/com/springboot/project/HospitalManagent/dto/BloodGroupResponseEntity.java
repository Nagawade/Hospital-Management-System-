package com.springboot.project.HospitalManagent.dto;

import com.springboot.project.HospitalManagent.entity.type.BloodGroupType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BloodGroupResponseEntity {
    private BloodGroupType bloodGroupType;
    private Long count;
}
