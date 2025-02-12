package com.employeeManagement.employee.Service;

import com.employeeManagement.employee.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInter {
    Employee addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(Long id);
    Employee updateEmployee(Long id, Employee updatedEmployee);
    void deleteEmployee(Long id);
}
