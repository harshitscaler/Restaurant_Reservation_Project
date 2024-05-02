package com.sst.restaurant_reservation_project.Services;

import com.sst.restaurant_reservation_project.CustomExceptions.DepartmentNotFound;
import com.sst.restaurant_reservation_project.Dtos.DepartmentDTO;
import com.sst.restaurant_reservation_project.Models.Department;
import com.sst.restaurant_reservation_project.Repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.Optional;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department createDepartment(Department department) {

        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id , DepartmentDTO departmentDto) {
        Department department = new Department();
        department.setId(id);
        department.setName(departmentDto.getName());

        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    public Optional<Department> getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId);
    }
    public Department getDepartmentByName(String name){

        Optional<Department> department = Optional.ofNullable(departmentRepository.findByName(name));
        if(department.isEmpty()){
            throw new DepartmentNotFound("Department not found with name: " + name);
        }
        return department.get();
    }
    public Department setDepartment(DepartmentDTO dto){
        Department newdepartment = new Department();
        newdepartment.setName(dto.getName());
        return departmentRepository.save(newdepartment);
    }

    public Iterable<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
