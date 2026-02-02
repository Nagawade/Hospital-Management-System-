package com.springboot.project.HospitalManagent.repository;

import com.springboot.project.HospitalManagent.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
