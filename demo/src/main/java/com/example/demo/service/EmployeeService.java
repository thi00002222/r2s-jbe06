package com.example.demo.service;

import com.example.demo.dto.EmployeeRequestDTO;
import com.example.demo.dto.EmployeeResponseDTO;
import com.example.demo.entity.Employee;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //    create methods here
    public EmployeeResponseDTO create(EmployeeRequestDTO request) {
        Employee employee = new Employee();
        mapToEntity(employee, request);
        return toDTO(employeeRepository.save(employee));
    }

    //    read all
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    //  read by id
    public EmployeeResponseDTO getEmployeeById(Integer id) {
        Employee employee = findById(id);
        return toDTO(employee);
    }

    //    update
    public EmployeeResponseDTO updateEmployee(Integer id, EmployeeRequestDTO request) {
        Employee employee = findById(id);
        mapToEntity(employee, request);
        return toDTO(employeeRepository.save(employee));
    }


    //    delete
    public void delete(Integer id) {
        Employee employee = findById(id);
        List<Employee> subs = employeeRepository.findBySupervisor(employee);
        subs.forEach(e -> e.setSupervisor(null));
        employeeRepository.saveAll(subs);
        employeeRepository.delete(employee);
    }


    private EmployeeResponseDTO toDTO(Employee employee) {
        return new EmployeeResponseDTO(
                employee.getEmployeeId(),
                employee.getFirstName() + " " + employee.getLastName(),
                employee.getBirthDate(),
                employee.getSupervisor() != null ? employee.getSupervisor().getEmployeeId() : null
        );
    }

    private void mapToEntity(Employee employee, EmployeeRequestDTO request) {
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setBirthDate(request.getBirthDate());

        if (request.getSupervisorId() != null) {
            Employee supervisor = findById(request.getSupervisorId());
            employee.setSupervisor(supervisor);
        } else {
            employee.setSupervisor(null);
        }
    }

    private Employee findById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }
}
