package com.sst.restaurant_reservation_project.Controllers;

import com.sst.restaurant_reservation_project.Dtos.RoleDTO;
import com.sst.restaurant_reservation_project.Models.Role;
import com.sst.restaurant_reservation_project.Services.RoleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {
    RoleService roleService ;
    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @GetMapping("")
    public Iterable<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @PostMapping("")
    public Role createRole(@RequestBody RoleDTO role) {
        return roleService.setRole(role);
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id){
        return roleService.getRoleById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRoleByid(@PathVariable Long id){
        roleService.deleteRole(id);
    }
    @PatchMapping("/{id}")
    public Role updateRole(@PathVariable Long id , @RequestBody RoleDTO dto){
        return roleService.updateRole(id,dto);
    }
}
