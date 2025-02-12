package com.employeeManagement.employee.repository;

import com.employeeManagement.employee.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
