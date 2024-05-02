package com.sst.restaurant_reservation_project.Controllers;

import com.sst.restaurant_reservation_project.CustomExceptions.DepartmentNotFound;
import com.sst.restaurant_reservation_project.Dtos.DepartmentDTO;
import com.sst.restaurant_reservation_project.Models.Department;
import com.sst.restaurant_reservation_project.Services.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/department")
@RestController
public class DepartmentController {
    DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping("")
    public Iterable<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{Id}")
    public Optional<Department> getDepartmentById(@PathVariable Long Id){
        Optional<Department> department = departmentService.getDepartmentById(Id);
        if(department.isEmpty()){
            throw new DepartmentNotFound(Id);
        }
        return department;
    }

    @PostMapping("")
    public Department createDepartment(@RequestBody DepartmentDTO departmentDTO){
        return departmentService.setDepartment(departmentDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
    }

    @PatchMapping("/{Id}")
    public Department updateDepartment(@PathVariable Long Id, @RequestBody DepartmentDTO departmentDTO){

        return departmentService.updateDepartment(Id,departmentDTO);
    }
}
