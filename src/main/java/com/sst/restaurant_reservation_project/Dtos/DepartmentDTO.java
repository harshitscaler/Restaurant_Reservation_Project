package com.sst.restaurant_reservation_project.Dtos;

import com.sst.restaurant_reservation_project.Models.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDTO {
    private String name;

    public boolean isValid() {
        return name != null;
    }

//    public static DepartmentDTO fromDepartment(Department department) {
//        DepartmentDTO departmentDTO = new DepartmentDTO();
//        departmentDTO.setName(department.getName());
//        return departmentDTO;
//    }
}
