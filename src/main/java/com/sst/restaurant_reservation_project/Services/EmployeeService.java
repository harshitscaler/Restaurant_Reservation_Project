package com.sst.restaurant_reservation_project.Services;

import com.sst.restaurant_reservation_project.Models.Department;
import com.sst.restaurant_reservation_project.Models.Employee;
import com.sst.restaurant_reservation_project.Models.Role;
import com.sst.restaurant_reservation_project.Repositories.DepartmentRepository;
import com.sst.restaurant_reservation_project.Repositories.EmployeeRepository;
import com.sst.restaurant_reservation_project.Repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final RoleRepository roleRepository;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, RoleRepository roleRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.roleRepository = roleRepository;
    }

    public Employee createEmployee(Employee employee, Long departmentId, Long roleId) {
        Department department = departmentRepository.findById(departmentId).orElse(null);
        Role role = roleRepository.findById(roleId).orElse(null);

        if (department != null && role != null) {
            employee.setDepartment(department);
            employee.setRole(role);
            return employeeRepository.save(employee);
        }
        return null;
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees() {
        Iterable<Employee> employees = employeeRepository.findAll();
        List<Employee> employeeList = new ArrayList<>();
        employees.forEach(employeeList::add);
        return employeeList;
    }

    public Employee updateEmployee(Long id, Employee employee, Long departmentId, Long roleId) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            Department department = departmentRepository.findById(departmentId).orElse(null);
            Role role = roleRepository.findById(roleId).orElse(null);
            if (department != null && role != null) {
                existingEmployee.setDepartment(department);
                existingEmployee.setRole(role);
            }
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
