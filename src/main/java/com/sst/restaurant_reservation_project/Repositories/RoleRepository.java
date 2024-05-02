package com.sst.restaurant_reservation_project.Repositories;

import com.sst.restaurant_reservation_project.Models.Role;
import com.sst.restaurant_reservation_project.Models.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleType(RoleType roleType);
}
