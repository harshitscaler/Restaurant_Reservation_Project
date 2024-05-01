package com.sst.restaurant_reservation_project.Dtos;

import com.sst.restaurant_reservation_project.Models.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
    private String name;
    private String email;
    private RoleDTO role;
    private DepartmentDTO department;

    public static EmployeeDTO fromEmployee(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName(employee.getName());
        employeeDTO.setEmail(employee.getEmail());
        if (employee.getRole() != null) {
            employeeDTO.setRole(RoleDTO.fromRole(employee.getRole()));
        }
        if (employee.getDepartment() != null) {
            employeeDTO.setDepartment(DepartmentDTO.fromDepartment(employee.getDepartment()));
        }
        return employeeDTO;
    }
}
