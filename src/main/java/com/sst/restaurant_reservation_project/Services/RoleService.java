package com.sst.restaurant_reservation_project.Services;

import com.sst.restaurant_reservation_project.CustomExceptions.RoleNotFoundException;
import com.sst.restaurant_reservation_project.Dtos.RoleDTO;
import com.sst.restaurant_reservation_project.Models.Role;
import com.sst.restaurant_reservation_project.Models.RoleType;
import com.sst.restaurant_reservation_project.Repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    RoleRepository roleRepository;
    RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }
    public Role setRole(RoleDTO dto){
        Role newRole = new Role();
        newRole.setSalary(dto.getSalary());
        newRole.setRoleType(RoleType.CHEF);
        if(dto.getRoleType().equals("WAITER")){
            newRole.setRoleType(RoleType.WAITER);
        }
        else if(dto.getRoleType().equals("MANAGER")){
            newRole.setRoleType(RoleType.MANAGER);
        }
        return roleRepository.save(newRole);
    }

    public Role getRoleById(Long id){
        Optional<Role> rol = roleRepository.findById(id);
        if(rol.isEmpty()) throw new RoleNotFoundException("Role not Found");
        return rol.get();
    }

    public Role getRoleByName(String name){
        RoleType roleType = RoleType.CHEF;
        if(name.equals("WAITER")) roleType = RoleType.WAITER;
        else if(name.equals("MANAGER")) roleType = RoleType.MANAGER;

        Optional<Role> rol = roleRepository.findByRoleType(roleType);
        if(rol.isEmpty()) throw new RoleNotFoundException("Role not Found");
        return rol.get();
    }

    public void deleteRole(Long id){
        Optional<Role> rol = roleRepository.findById(id);
        if(rol.isEmpty()) throw new RoleNotFoundException("Already not there");
        else roleRepository.deleteById(id);
    }

    public Role updateRole(Long id , RoleDTO role){
        Role rol = new Role();
        rol.setId(id);
        rol.setSalary(role.getSalary());
        rol.setRoleType(RoleType.MANAGER);
        if(role.getRoleType().equals("CHEF")) rol.setRoleType(RoleType.CHEF);
        if(role.getRoleType().equals("WAITER")) rol.setRoleType(RoleType.WAITER);
        return roleRepository.save(rol);
    }

    public Iterable<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
