package com.sst.restaurant_reservation_project.Dtos;

import com.sst.restaurant_reservation_project.Models.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDTO {
    private String roleType;
    private Long salary;

    public boolean isValid() {
        return roleType != null && salary != null;
    }

//    public static RoleDTO fromRole(Role role) {
//        RoleDTO roleDTO = new RoleDTO();
//        roleDTO.setRoleType(role.getRoleType().name());
//        roleDTO.setSalary(role.getSalary());
//        return roleDTO;
//    }
}
