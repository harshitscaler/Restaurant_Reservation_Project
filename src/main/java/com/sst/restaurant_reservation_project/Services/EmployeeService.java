package com.sst.restaurant_reservation_project.Services;

import com.sst.restaurant_reservation_project.Dtos.EmployeeDTO;
import com.sst.restaurant_reservation_project.Models.Department;
import com.sst.restaurant_reservation_project.Models.Employee;
import com.sst.restaurant_reservation_project.Models.Role;
import com.sst.restaurant_reservation_project.Repositories.DepartmentRepository;
import com.sst.restaurant_reservation_project.Repositories.EmployeeRepository;
import com.sst.restaurant_reservation_project.Repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final RoleService roleService;
    private final DepartmentService departmentService;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentService departmentService, RoleService roleService) {
        this.employeeRepository = employeeRepository;
        this.departmentService = departmentService;
        this.roleService = roleService;
    }

//    public Employee createEmployee(EmployeeDTO employeeDTO) {
//              Employee employee = new Employee();
//              employee.setName(employeeDTO.getName());
//              employee.setEmail(employeeDTO.getEmail());
//              employee.setDepartment(departmentService.getDepartmentByName(employeeDTO.getDepartmentName()));
//              employee.setRole(roleService.getRoleByName(employeeDTO.getRole()));
//
//              departmentService.getDepartmentByName(employeeDTO.getName()).getEmployees().add(employee);
//                roleService.getRoleByName(employeeDTO.getName()).getEmployees().add(employee);
//                return employeeRepository.save(employee);
//
//    }

    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDepartment(departmentService.getDepartmentByName(employeeDTO.getDepartmentName()));
        employee.setRole(roleService.getRoleByName(employeeDTO.getRole()));

        departmentService.getDepartmentByName(employeeDTO.getDepartmentName()).getEmployees().add(employee);
        roleService.getRoleByName(employeeDTO.getRole()).getEmployees().add(employee);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id , EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDepartment(departmentService.getDepartmentByName(employeeDTO.getDepartmentName()));
        employee.setRole(roleService.getRoleByName(employeeDTO.getRole()));
        return employeeRepository.save(employee);
    }

//    public Employee updateEmployee(Long id , EmployeeDTO employeeDTO) {
//        Employee employee = new Employee();
//        employee.setId(id);
//        employee.setName(employeeDTO.getName());
//        employee.setEmail(employeeDTO.getEmail());
//        employee.setDepartment(departmentService.getDepartmentByName(employeeDTO.getName()));
//        employee.setRole(roleService.getRoleByName(employeeDTO.getName()));
//        return employeeRepository.save(employee);
//    }

    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
