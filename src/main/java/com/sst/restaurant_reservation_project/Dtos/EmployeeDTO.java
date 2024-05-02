package com.sst.restaurant_reservation_project.Dtos;

import com.sst.restaurant_reservation_project.Models.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
    private String name;
    private String email;
    private String role;
    private String departmentName;

    public boolean isValid() {
        return name != null && email != null && role != null && departmentName != null;
    }
}
