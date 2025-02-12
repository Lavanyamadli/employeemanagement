package com.employeeManagement.employee.Service;

import com.employeeManagement.employee.Service.EmployeeServiceInter;
import com.employeeManagement.employee.model.Employee;
import com.employeeManagement.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService implements EmployeeServiceInter {  // Ensure class is not commented out

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        log.info("Adding new employee: {}", employee.getName());
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees");
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        log.info("Fetching employee with ID: {}", id);
        return employeeRepository.findById(id);
    }

    @Override
    @Transactional
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        log.info("Updating employee with ID: {}", id);
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(updatedEmployee.getName());
                    employee.setEmail(updatedEmployee.getEmail());
                    employee.setRole(updatedEmployee.getRole());
                    employee.setDepartment(updatedEmployee.getDepartment());
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }

    @Override
    public void deleteEmployee(Long id) {
        log.info("Deleting employee with ID: {}", id);
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found with ID: " + id);
        }
        employeeRepository.deleteById(id);
    }
}