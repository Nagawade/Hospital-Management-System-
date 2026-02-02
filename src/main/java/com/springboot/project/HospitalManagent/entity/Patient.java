package com.springboot.project.HospitalManagent.entity;

import com.springboot.project.HospitalManagent.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.engine.internal.Cascade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity


@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    //@Column(name="patient_name",nullable =false)
    private String name;
    private LocalDate birthDate;
    private String gender;
    private String email ;

    @CreationTimestamp
    @Column(name="created_at",nullable=false,updatable=false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType BloodGroup;

    @OneToMany(mappedBy = "patient",  cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    private List<Appointment> appointments = new ArrayList<>();

    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "patient_insurance_id")
    private Insurance insurance;

    @OneToOne
    private User user;




    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt + '\''+
                ", BloodGroup='" + BloodGroup + '\'' +
                '}';
    }


}
