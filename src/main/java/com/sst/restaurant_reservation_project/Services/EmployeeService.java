package com.sst.restaurant_reservation_project.Services;

import com.sst.restaurant_reservation_project.Models.Customer;
import com.sst.restaurant_reservation_project.Models.Employee;
import com.sst.restaurant_reservation_project.Repositories.CustomerRepository;
import com.sst.restaurant_reservation_project.Repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees() {
        Iterable<Employee> employees =  employeeRepository.findAll();
        List<Employee> employeeList = new ArrayList<>();
        employees.forEach(employeeList::add);
        return employeeList;
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }

    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
