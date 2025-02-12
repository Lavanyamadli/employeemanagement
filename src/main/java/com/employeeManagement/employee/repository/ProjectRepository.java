package com.employeeManagement.employee.repository;

import com.employeeManagement.employee.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
