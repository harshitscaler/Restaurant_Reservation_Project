package com.sst.restaurant_reservation_project.Controllers;

import com.sst.restaurant_reservation_project.CustomExceptions.EmployeeNotFound;
import com.sst.restaurant_reservation_project.Dtos.EmployeeDTO;
import com.sst.restaurant_reservation_project.Models.Employee;
import com.sst.restaurant_reservation_project.Services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
    return employeeService.getAllEmployees();
}

    @PostMapping("")
    public Employee createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @PatchMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable Long employeeId , @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(employeeId,employeeDTO);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeId) {
        if (employeeService.deleteEmployee(employeeId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new EmployeeNotFound(employeeId);
        }
    }
}
